package com.metaphorce.shopall.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "ShopAll",
                version = "1.0.0",
                description = "ShopAll es una plataforma de comercio electrónico diseñada para ofrecer una amplia variedad de productos a consumidores de todo el mundo. La plataforma se enfoca en proporcionar una experiencia de compra intuitiva y segura, y está destinada a crecer a medida que más vendedores y compradores se unan a ella."
        )

)

public class OpenApiConfig implements WebMvcConfigurer {

        @Bean
        public GroupedOpenApi publicApi() {
                return GroupedOpenApi.builder()
                        .group("public")
                        .pathsToMatch("/api/**")
                        .build();
        }
}