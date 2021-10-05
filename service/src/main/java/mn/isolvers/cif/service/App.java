package mn.isolvers.cif.service;

import mn.isolvers.common.annotation.iSolversMicroservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@iSolversMicroservice(title = "Temp1 service",desc = "first template service for example")
public class App extends SpringBootServletInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        LOGGER.warn(" ~~~~~ temp1 service started! ~~~~~ ");
    }

}
