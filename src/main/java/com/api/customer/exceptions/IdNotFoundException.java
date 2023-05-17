package com.api.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Id Not Found Exception.
 * 
 * @author thutrang
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends BaseException {

    /**
     * An exception is thrown when the ID is not found.
     * Inherit from the Exception class and set the HTTP status code to NOT_FOUND.
     * 
     * @param exceptionResponse The ExceptionResponse object contains information
     *                          about the exception.
     */
    public IdNotFoundException(ExceptionResponse exceptionResponse) {
        super(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
