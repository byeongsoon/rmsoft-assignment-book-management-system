package com.rmsoft.bookmanagementsystem.global.config.doc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(new Info().title("도서관리 시스템 REST API Spec")
                .description("서버에서 제공하는 REST API 스펙을 기술합니다")
                .version("v0.0.1")).externalDocs(new ExternalDocumentation());
    }

}
