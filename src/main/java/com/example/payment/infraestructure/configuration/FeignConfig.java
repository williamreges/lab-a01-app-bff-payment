package com.example.payment.infraestructure.configuration;

import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

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
}
