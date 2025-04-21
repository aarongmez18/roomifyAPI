package com.back.roomify.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Roomify Core API",
        version = "1.0.0",
        description = "API for searching users and rooms, with each of their details"
))
public class OpenApi {
}
