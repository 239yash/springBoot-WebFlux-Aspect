package com.webflux.demoApp.config;

import com.webflux.demoApp.exception.TestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@Configuration
public class ApplicationExceptionHandler {
    @ExceptionHandler(TestException.class)
    ResponseEntity<?> exceptionHandler(TestException ex) {
        log.debug("handling exception: " + ex);
        return ResponseEntity.ok("error occurred: " + ex.getMessage());
    }
}
