package com.example.payment.bdd.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WireMockTestConfiguration {

    @Value("${wiremock.port}")
    private Integer portWiremock;


    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer wireMockServer() {
        return new WireMockServer(
                WireMockConfiguration
                        .options()
                        .port(portWiremock)
                        .usingFilesUnderClasspath("wiremock"));
    }
}
