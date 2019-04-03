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

import org.apache.camel.main.Main;

public class Fedora4IndexIntegration {

    public static void main(String... args) throws Exception {
        // Camel standalone application support
        Main main = new Main();

        // Initialize and register Route builder
        main.addRouteBuilder(new Fedora4IndexIntegrationRoute());

        // Run Camel until stopped by OS process termination
        main.run(args);
    }

}
