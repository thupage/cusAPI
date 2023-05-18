package com.api.customer.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Exception class.
 * 
 * @author thutrang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {

    private String code;
    private String message;
    private HttpStatus statusCode;
    private ExceptionResponse error;

    /**
     * Constructs a new Exception with the specified code, message, and status code.
     * 
     * @param code       The error code.
     * @param message    The error message.
     * @param statusCode The HTTP status code.
     */
    public BaseException(String code, String message, HttpStatus statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    /**
     * Constructs a new Exception with the specified exception response and status
     * code.
     * 
     * @param exceptionResponse The exception response.
     * @param statusCode        The HTTP status code.
     */
    public BaseException(ExceptionResponse exceptionResponse, HttpStatus statusCode) {
        this.error = exceptionResponse;
        this.statusCode = statusCode;
    }
}
