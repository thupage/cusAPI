package com.api.customer.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Exception class.
 * 
 * @author thutrang
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ControllerAdvice
@NoArgsConstructor
public class BaseException extends RuntimeException {

    private ExceptionResponse errors;

    private static Logger logger = LoggerFactory.getLogger(BaseException.class);

    /**
     * Constructs a new Exception with the specified exception response and status
     * code.
     * 
     * @param exceptionResponse The exception response.
     * @param statusCode        The HTTP status code.
     */
    public BaseException(ExceptionResponse exceptionResponse, HttpStatus statusCode) {
        this.errors = exceptionResponse;
    }

    @ExceptionHandler(value = { BadRequestException.class })
    public ResponseEntity<?> handleException(BadRequestException ex) {
        logger.error("Exception: ", ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getErrors().getCode(), ex.getErrors().getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { IdNotFoundException.class })
    public ResponseEntity<?> handleException(BaseException ex) {
        logger.error("Exception: ", ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getErrors().getCode(), ex.getErrors().getMessage()),
                HttpStatus.NOT_FOUND);
    }
}
