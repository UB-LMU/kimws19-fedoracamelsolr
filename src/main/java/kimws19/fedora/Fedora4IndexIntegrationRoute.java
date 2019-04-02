package kimws19.fedora;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import javax.jms.ConnectionFactory;
import java.util.List;

import static org.apache.camel.component.jms.JmsComponent.jmsComponentAutoAcknowledge;

public class Fedora4IndexIntegrationRoute extends RouteBuilder {

    private static final String RESOURCE = "http://fedora.info/definitions/v4/repository#Resource";
    private static final String RESOURCE_MODIFICATION = "http://fedora.info/definitions/v4/event#ResourceModification";

    @Override
    public void configure() {
        // Obtain Camel context to modify it (usually done in configuration)
        CamelContext context = getContext();
        context.setStreamCaching(true);

        // Register JMS component in Camel context
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        context.addComponent("jms", jmsComponentAutoAcknowledge(connectionFactory));

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
                    .when(exchangeProperty("fedoraEvents").contains(RESOURCE_MODIFICATION))
                        .to("direct:modified")
                .otherwise()
                    .log(LoggingLevel.ERROR, "Unexpected events: ${exchangeProperty.fedoraEvents}");

        // Route to handle resource modifications
        from("direct:modified").id("handle-modifications")
                .log("Resource ${exchangeProperty.fedoraUri} was modified");

    }
}
