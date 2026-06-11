package com.example.payment.infraestructure.exception.handler;

import com.example.payment.infraestructure.exception.model.MessageItem;
import com.example.payment.infraestructure.exception.model.ResponseExceptionCustom;
import feign.FeignException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomResponseFeignExceptionHandler {


    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Object> feignValidation(FeignException ex) {

        var status = switch (ex.status()) {
            case -1 -> 422;
            default -> ex.status();
        };

        return ResponseEntity
                .status(status) // Bad Request
                .body(new ResponseExceptionCustom(List.of(
                        new MessageItem(
                                String.valueOf(status),
                                ex.getMessage()
                        )
                )));
    }

}
