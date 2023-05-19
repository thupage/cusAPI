package com.api.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Bad Request Exception.
 * 
 * @author thutrang
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends BaseException {

    public BadRequestException(ExceptionResponse exceptionResponse) {
        super(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
