package com.example.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppBffPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppBffPaymentApplication.class, args);
    }

}
