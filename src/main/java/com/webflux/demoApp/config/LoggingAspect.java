package com.webflux.demoApp.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class LoggingAspect {
    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void logBeforePostMapping(JoinPoint joinPoint) {
        log.info("Test Test1");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("Test Test2");
            if (arg != null) {
                log.info("Test Test3");
                if (Arrays
                        .stream(((MethodSignature) joinPoint.getSignature()).getMethod().getParameterAnnotations())
                        .flatMap(Arrays::stream)
                        .anyMatch(annotation -> annotation.annotationType().equals(RequestBody.class))) {
                    log.info("Request Body(Logged in Aspect) - " + arg);
                }

                if (Arrays
                        .stream(((MethodSignature) joinPoint.getSignature()).getMethod().getParameterAnnotations())
                        .flatMap(Arrays::stream)
                        .anyMatch(annotation -> annotation.annotationType().equals(RequestParam.class))) {
                    log.info("Request Param(Logged in Aspect) - " + arg);
                }
            }
        }
    }
}
