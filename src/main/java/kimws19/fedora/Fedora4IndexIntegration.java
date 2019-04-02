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
