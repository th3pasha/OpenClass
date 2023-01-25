package com.th3.openclass.exception;

public class BusinessException extends RuntimeException{
    private final ExceptionPayload payload;

    public BusinessException(ExceptionPayload payload) {
        this.payload = payload;
    }
}