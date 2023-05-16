package com.api.customer.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class Exception extends RuntimeException {
    
    private String code;
    private String message;
    private HttpStatus statusCode;
    private ExceptionResponse error;

    public Exception(String code, String message, HttpStatus statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    public Exception(ExceptionResponse exceptionResponse, HttpStatus statusCode) {
        this.error = exceptionResponse;
        this.statusCode = statusCode;
    }
}
