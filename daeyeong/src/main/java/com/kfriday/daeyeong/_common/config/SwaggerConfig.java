package com.kfriday.daeyeong._common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@OpenAPIDefinition(
        servers = @Server(url = "${base-url}", description = "server base url"),
        info = @Info(
                title = "kfriday 입출고 서버 API",
                version = "1.0"
        )
)
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        OpenAPI openAPI = new OpenAPI();

        openAPI.setExtensions(new HashMap<>());
        openAPI.getExtensions().put("doc-expansion", "none");
        openAPI.getExtensions().put("tags-sorter", "alpha");
        openAPI.getExtensions().put("operationsSorter", "method");

        return openAPI;
    }

}