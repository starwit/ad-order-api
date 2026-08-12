package de.starwit.adorder.impl.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI adOrderOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AD Stack Ride Order API")
                        .description("Reference implementation of the AD Stack Ride Order REST API")
                        .version("1.0.0")
                        .license(new License()
                                .name("GNU Affero General Public License v3.0")
                                .url("https://www.gnu.org/licenses/agpl-3.0.html")));
    }
}
