package com.api.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author thutrang
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends Exception {

    public IdNotFoundException(ExceptionResponse exceptionResponse) {
        super(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
