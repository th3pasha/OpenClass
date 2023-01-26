package com.th3.openclass.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;




@Getter
@Setter
@NoArgsConstructor
public class ExceptionPayload {
    private Integer code;
    private HttpStatus status;
    private String message;

    public ExceptionPayload(Integer code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
