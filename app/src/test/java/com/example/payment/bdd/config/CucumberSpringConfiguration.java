package com.example.payment.bdd.config;

import com.example.payment.AppBffPaymentApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.wiremock.spring.EnableWireMock;

@CucumberContextConfiguration
@SpringBootTest(
        classes = AppBffPaymentApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@EnableWireMock
public class CucumberSpringConfiguration {
}
