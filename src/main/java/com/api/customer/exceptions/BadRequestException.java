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

    /**
     * Exception to represent BadRequest error.
     * 
     * @param errorResponse The ErrorResponse contains information about the BadRequest error.
     */
    public BadRequestException(ErrorResponse errorResponse) {
        super(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
