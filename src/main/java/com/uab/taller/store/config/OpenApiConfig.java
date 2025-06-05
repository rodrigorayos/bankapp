package com.uab.taller.store.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo(){
        return new Info().title("Store Service")
                .description("Aplicación bancaria rey, de esas que tu usas")
                .license(new License().name("Apache 2.0")
                        .url("https://www.youtube.com/watch?v=dQw4w9WgXcQ"))
                .contact(new Contact().name("Juanito Arcoiris")
                        .email("juanito.arcoiris.com"));
    }
}
