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
                                .description("REST API for submitting and managing ride orders to a vehicle's autonomous driving (AD) stack, and for querying current vehicle status and component inventory. Runs within the vehicle's onboard network and serves exactly one vehicle. Onboard HMIs reach it directly; backend systems reach it via an API gateway which handles vehicle identification and routing. ")
                                .license(
                                        new License()
                                                .name("GNU Affero General Public License v3.0")
                                                .url("https://www.gnu.org/licenses/agpl-3.0.html")
                                )
                                .version("1.0.0")
                )
        ;
    }
}