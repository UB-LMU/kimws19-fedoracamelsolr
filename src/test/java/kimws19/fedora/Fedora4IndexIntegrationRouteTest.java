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

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Fedora4IndexIntegrationRouteTest extends CamelTestSupport {

    @Before
    public void adviceJMSConsumerRoute() throws Exception {
        context.getRouteDefinition("consume-jms-messages")
                .adviceWith(context, new AdviceWithRouteBuilder() {
                    @Override
                    public void configure() {
                        replaceFromWith("stub:jms:topic:fedora");
                        weaveByToUri("direct:deleted").replace().to("mock:deleted");
                    }
                });
    }

    @Test
    public void Delete_event_is_routed_to_delete_route() throws Exception {
        String json = createFedora4EventJson("/uuid:1234", Arrays.asList(
                "http://fedora.info/definitions/v4/event#ResourceDeletion",
                "http://www.w3.org/ns/prov#Activity"));
        Map<String, Object> headers = Collections.singletonMap("org.fcrepo.jms.identifier", "/uuid:1234");
        MockEndpoint deleteEndpoint = getMockEndpoint("mock:deleted");
        context.start();

        sendBody("stub:jms:topic:fedora", json, headers);

        deleteEndpoint.expectedMessageCount(1);
        assertMockEndpointsSatisfied();
    }

    private String createFedora4EventJson(String id, List<String> eventTypes) {
        String idPart = String.format("\"id\" : \"%s\"", id);
        String eventList = eventTypes.stream()
                .map(s -> String.format("\"%s\"", s))
                .collect(Collectors.joining(", "));
        String eventsPart = "\"wasGeneratedBy\" : { " + String.format("\"type\":[ %s ]", eventList) + " }";
        String resourceType = "\"type\":[\"http://fedora.info/definitions/v4/repository#Resource\"]";
        return String.format("{ %s, %s, %s }", idPart, eventsPart, resourceType);
    }

    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new Fedora4IndexIntegrationRoute();
    }

    @Override
    public boolean isUseAdviceWith() {
        return true;
    }
}
