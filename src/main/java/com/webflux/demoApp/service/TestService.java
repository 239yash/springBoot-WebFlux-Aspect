package com.webflux.demoApp.service;

import com.webflux.demoApp.exception.TestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class TestService {
    public Mono<?> testMethod() {
        return Mono.just("Test");
//        return testMethod2().map(data -> data + "test2");
    }

    public Mono<?> testMethod2() {
        return Mono.error(new TestException("error"));
    }
}
