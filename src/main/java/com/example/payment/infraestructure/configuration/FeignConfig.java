package com.example.payment.infraestructure.configuration;

import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static java.util.Optional.ofNullable;

@Configuration
public class FeignConfig {

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
        return requestTemplate ->
                requestTemplate
                        .header(
                                "correlationID",
                                ofNullable(MDC.get("correlationID")).orElse(UUID.randomUUID().toString()));

    }
}
