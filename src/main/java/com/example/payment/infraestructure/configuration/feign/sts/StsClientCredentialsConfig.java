package com.example.payment.infraestructure.configuration.feign.sts;

import com.example.payment.infraestructure.configuration.feign.ErrorDecoderCustom;
import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static java.util.Optional.ofNullable;

@Configuration
public class StsClientCredentialsConfig {

    private final JWTSTSGenerator jwtstsGenerator;

    public StsClientCredentialsConfig(JWTSTSGenerator jwtstsGenerator) {
        this.jwtstsGenerator = jwtstsGenerator;
    }

    @Bean
    public Retryer configRetry() {
        return new Retryer.Default(
                100L,
                TimeUnit.SECONDS.toSeconds(3L),
                3);
    }

    @Bean
    public ErrorDecoder configErroDecoder() {
        return new ErrorDecoderCustom();
    }


    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            var token = jwtstsGenerator.generatorToken();
            requestTemplate.header(HttpHeaders.AUTHORIZATION, "Bearer " + token);
            requestTemplate.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
            requestTemplate.header("correlationId", ofNullable(MDC.get("correlationId")).orElse(UUID.randomUUID().toString()));
            requestTemplate.header("x-apikey", jwtstsGenerator.getClienteId());

        };
    }
}
