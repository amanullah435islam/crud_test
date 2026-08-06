package com.example.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()

                .info(
                        new Info()
                                .title("Hospital Management System API")

                                .description("REST API Documentation for Hospital Management System")

                                .version("1.0.0")

                                .contact(new Contact()

                                        .name("Md. Amanullah")

                                        .email("aman435islam@gmail.com")

                                        .url("https://github.com/amanullah435islam"))

                                .license(new License()

                                        .name("Apache 2.0")

                                        .url("https://www.apache.org/licenses/LICENSE-2.0")
                                )
                )



                .servers(List.of(

                        new Server()
                                .url("http://localhost:8080/swagger-ui/index.html#/Doctor%20APIs")
//                                .url("http://localhost:8080")
                                .description("Development Server"),

                        new Server()
                                .url("https://custom.api.company.com")
                                .description("Production Server")

                ))

                .externalDocs(
                        new ExternalDocumentation()
                                .description("GitHub Repository")

                                .url("https://github.com/amanullah435islam")
                )

                // JWT Authentication
                .addSecurityItem(
                        new SecurityRequirement()
                                .addList("bearerAuth")
                )

                .components(
                        new Components()
                                .addSecuritySchemes(
                                        "bearerAuth",
                                        new SecurityScheme()
                                                .name("Authorization")
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                );
    }
}