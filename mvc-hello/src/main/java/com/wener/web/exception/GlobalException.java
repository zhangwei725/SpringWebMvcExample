package com.wener.web.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlobalException extends RuntimeException {
    public static final String DEFAULT_ERROR_MESSAGE = "系统忙，请稍后再试";
    @Setter
    @Getter
    private  String msg;
    public GlobalException(String msg) {
        this.msg= msg ==null || msg.equals("") ? DEFAULT_ERROR_MESSAGE : msg;
    }
}
