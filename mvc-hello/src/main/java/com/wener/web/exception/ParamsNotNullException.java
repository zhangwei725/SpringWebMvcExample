package com.wener.web.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ParamsNotNullException extends RuntimeException {
    private static final String DEFAULT_MSG = "Parameter is null or empty!";
    @Getter
    @Setter
    private String message;

    public ParamsNotNullException(String msg) {
        this.message = msg == null ? DEFAULT_MSG : msg;
    }
}
