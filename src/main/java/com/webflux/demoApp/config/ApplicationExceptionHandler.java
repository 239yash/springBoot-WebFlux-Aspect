package com.webflux.demoApp.config;

import com.webflux.demoApp.exception.TestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@Slf4j
@Configuration
public class ApplicationExceptionHandler {
    @ExceptionHandler(TestException.class)
    Mono<?> exceptionHandler(TestException ex, ServerWebExchange exchange) {
        log.error("handling exception: " + ex);
        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
        return Mono.just("error occurred: " + ex.getMessage());
    }
}
