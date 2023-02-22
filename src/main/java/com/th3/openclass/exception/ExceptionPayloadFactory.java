package com.th3.openclass.exception;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ExceptionPayloadFactory {

    TECHNICAL_ERROR(0, HttpStatus.INTERNAL_SERVER_ERROR, "technical.error"),
    INVALID_PAYLOAD(1, HttpStatus.BAD_REQUEST, "invalid.request.payload"),
    STUDENT_NOT_FOUND(2, HttpStatus.NOT_FOUND, "student.not.found"),
    FIELD_NOT_FOUND(3, HttpStatus.NOT_FOUND, "field.not.found"),
    ACCOUNT_EXISTS(5, HttpStatus.NOT_FOUND, "account.already.exists"),
    ACCOUNT_NOT_FOUND(4, HttpStatus.NOT_FOUND, "account.not.found");

    private final Integer code;
    private final HttpStatus status;
    private final String message;

    public ExceptionPayload get() {
        return new ExceptionPayload(code, status, message);
    }
}
