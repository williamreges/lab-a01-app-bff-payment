package com.example.payment.infraestructure.configuration.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import static java.util.Optional.ofNullable;

@Component
public class CorrelationIdIHandlerInterceptor implements HandlerInterceptor {

    private final String CORRELATION_ID = "correlationId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        ofNullable(
                request.getHeader(CORRELATION_ID))
                .ifPresent(
                        s -> MDC.put(CORRELATION_ID, s));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        MDC.remove(CORRELATION_ID);
    }
}
