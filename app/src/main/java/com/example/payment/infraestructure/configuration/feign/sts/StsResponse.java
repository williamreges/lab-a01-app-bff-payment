package com.example.payment.infraestructure.configuration.feign.sts;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record StsResponse(
        String accessToken,
        String tokenType,
        String expiresIn,
        String refreshToken,
        String scope,
        String active
) {
}
