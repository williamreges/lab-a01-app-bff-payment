package com.example.payment.infraestructure.configuration.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;
import java.util.List;


@Configuration
class CORSConfig {

    @Bean
    public CorsFilter corsFilter() {

        final var config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        config.setAllowedHeaders(List.of(
                "Content-Type",
                "Authorization",
                "Access-Control-Allow-Headers",
                "Access-Control-Allow-Origin",
                "Content-Disposition",
                "X-Requested-With",
                "X-Amz-Date",
                "X-Api-Key",
                "correlationId",
                "x-origin-cf-apigw",
                "X-Amz-Security-Token",
                "pragma",
                "cache-control",
                "timeout"
        ));
        config.setExposedHeaders(Collections.singletonList("Content-Disposition"));

        final var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

}
