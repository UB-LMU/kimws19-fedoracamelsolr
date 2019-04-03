/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package kimws19.fedora;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.solr.SolrConstants;
import org.apache.http.HttpHeaders;

import javax.jms.ConnectionFactory;
import java.util.List;

import static org.apache.camel.component.http4.HttpMethods.GET;
import static org.apache.camel.component.jms.JmsComponent.jmsComponentAutoAcknowledge;

public class Fedora4IndexIntegrationRoute extends RouteBuilder {

    private static final String RESOURCE = "http://fedora.info/definitions/v4/repository#Resource";
    private static final String RESOURCE_DELETION = "http://fedora.info/definitions/v4/event#ResourceDeletion";
    private static final String RESOURCE_MODIFICATION = "http://fedora.info/definitions/v4/event#ResourceModification";

    @Override
    public void configure() {
        // Obtain Camel context to modify it (usually done in configuration)
        CamelContext context = getContext();
        context.setStreamCaching(true);

        // Register JMS component in Camel context
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        context.addComponent("jms", jmsComponentAutoAcknowledge(connectionFactory));

        // Configure global error handling with 5 redelivery attempts and dead letter channel
        errorHandler(deadLetterChannel("log:dead?level=ERROR")
                .maximumRedeliveries(5)
                .retryAttemptedLogLevel(LoggingLevel.WARN)
                .redeliveryDelay(5000));

        from("jms:topic:fedora").id("consume-jms-messages")
                // Route for receiving JMS messages from Fedora
                .setProperty("fedoraEvents", jsonpath("wasGeneratedBy.type", List.class))
                .setProperty("fedoraUri", jsonpath("id", String.class))
                .setProperty("fedoraType", jsonpath("type", List.class))

                // Filter out unwanted events
                .filter(header("org.fcrepo.jms.identifier").startsWith("/"))
                .filter(exchangeProperty("fedoraType").contains(RESOURCE))

                // Choose where to route events to
                .choice()
                    .when(exchangeProperty("fedoraEvents").contains(RESOURCE_DELETION))
                        .to("direct:deleted")
                    .when(exchangeProperty("fedoraEvents").contains(RESOURCE_MODIFICATION))
                        .to("direct:modified")
                .otherwise()
                    .log(LoggingLevel.ERROR, "Unexpected events: ${exchangeProperty.fedoraEvents}");

        // Route for obtaining a Fedora resource in RDF-XML format
        from("direct:fcrepo-resource").id("fcrepo-get-resource")
                .setHeader(HttpHeaders.ACCEPT, constant("application/rdf+xml"))
                .setHeader(Exchange.HTTP_URI, exchangeProperty("fedoraUri"))
                .setHeader(Exchange.HTTP_METHOD, GET) // default would be post
                .to("http4://fedora?authUsername=fedoraAdmin&authPassword=secret3");

        // Route to handle resource modifications
        from("direct:modified").id("handle-modifications")
                .log("Resource ${exchangeProperty.fedoraUri} was modified")
                .to("direct:fcrepo-resource")
                .to("xslt:fedora2solr.xsl")
                .to("direct:solr-ingest");

        // Route to handle resource deletions
        from("direct:deleted").id("handle-deletions")
                .log("Resource ${exchangeProperty.fedoraUri} was deleted")
                .to("direct:solr-delete");

        // Route to ingest `add` document to Solr
        from("direct:solr-ingest").id("solr-ingest-document")
                .log("Ingesting ${exchangeProperty.fedoraUri} to Solr")
                .setHeader(Exchange.CONTENT_TYPE, constant(null)) // Solr component bug
                .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_INSERT))
                .to("solr://localhost:8080/solr/collection1")
                .to("direct:solr-commit");

        // Route to send `delete` document to Solr
        from("direct:solr-delete").id("solr-delete-document")
                .log("Deleting ${exchangeProperty.fedoraUri} from Solr")
                .setBody(exchangeProperty("fedoraUri"))
                .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_DELETE_BY_ID))
                .to("solr://localhost:8080/solr")
                .to("direct:solr-commit");

        // Route to issue commit for a Solr core
        from("direct:solr-commit")
                .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_COMMIT))
                .to("solr://localhost:8080/solr/collection1");

    }
}
