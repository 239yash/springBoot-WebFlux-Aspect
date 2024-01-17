package com.webflux.demoApp.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestException extends RuntimeException{
    public TestException(String message) {
        super(message);
    }
}
