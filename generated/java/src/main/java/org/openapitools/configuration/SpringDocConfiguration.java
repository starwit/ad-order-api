package org.openapitools.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfiguration {

    @Bean(name = "org.openapitools.configuration.SpringDocConfiguration.apiInfo")
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("AD Stack Ride Order API")
                                .description("API for submitting and managing ride orders to a vehicle's autonomous driving (AD) stack. This API runs within the vehicle's onboard network and serves exactly one vehicle. Onboard HMIs reach it directly; external backend systems reach it via an API gateway, which is responsible for vehicle identification and routing (e.g. mapping a fleet vehicle ID to this vehicle's network endpoint). This API is purely operational (vehicle/route oriented) and does not carry any customer or passenger data. ")
                                .version("0.0.1")
                )
        ;
    }
}