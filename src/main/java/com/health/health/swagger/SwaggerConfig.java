package com.health.health.swagger;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Reem on 15/12/2016.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * {@inheritDoc}
     */
    final ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Client")
                .description("Health service API")
                .license("")
                .licenseUrl("")
                .termsOfServiceUrl("")
                .contact(new Contact("", "", ""))
                .build();
    }
}
