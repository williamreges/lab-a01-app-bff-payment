package com.example.payment.infraestructure.configuration;

import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class ErrorDecoderCustom implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        var feignException = FeignException.errorStatus(s, response);
        var httpStatus = HttpStatus.valueOf(feignException.status());

        return switch (httpStatus) {
            case REQUEST_TIMEOUT,
                 TOO_MANY_REQUESTS,
                 INTERNAL_SERVER_ERROR,
                 BAD_GATEWAY,
                 SERVICE_UNAVAILABLE,
                 GATEWAY_TIMEOUT -> retryableException(feignException, response);
            default -> feignException;
        };


    }
    private RetryableException retryableException(FeignException feignException, Response response) {
        return new RetryableException(
                response.status(),
                feignException.getMessage(),
                response.request().httpMethod(),
                feignException,
                LocalDate.now().toEpochDay(),
                response.request());
    }
}

