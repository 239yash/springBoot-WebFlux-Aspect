package com.webflux.demoApp.controller;

import com.webflux.demoApp.service.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class TestController {
    private final TestService testService;
    @PostMapping
    public Mono<?> testMethod(@RequestBody Object requestObject) {
        log.info("Request Body POST(Logged in method) - " + requestObject);
        return testService.testMethod();
    }

    @PutMapping
    public Mono<?> testPutMethod(@RequestBody Object requestObject) {
        log.info("Request Body PUT(Logged in method) - " + requestObject);
        return testService.testMethod();
    }
}
