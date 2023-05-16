package com.api.customer.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Exception Response.
 * 
 * @author thutrang
 */
@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String code;
    private String message;
}
