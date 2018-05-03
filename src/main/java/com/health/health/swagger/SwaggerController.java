package com.health.health.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by Reem on 18/12/2016.
 */
@RestController
@RequestMapping
public class SwaggerController {

    @Autowired
    private Environment env;

    /**
     * {@inheritDoc}
     */
    @RequestMapping(value = "")
    public final String info() {
        return "<h3>FCA project</h3>"
                + "Micro-service name : <b>" + env.getProperty("spring.application.name") + "</b>"
                + "<br/> Version : " + env.getProperty("info.version")
                + "<br/> Running on port : " + env.getProperty("server.port")
                + "<br/> Running profile(s) : " + Arrays.asList(env.getActiveProfiles())
                + "<br/>"
                + "<br/> Swagger APIs : <a href=\"/swagger-ui.html\">/swagger</a>"
                + "<br/> More info: <a href=\"/info\">/info</a>";
    }
}
