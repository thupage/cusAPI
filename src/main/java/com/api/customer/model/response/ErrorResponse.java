package com.api.customer.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Error Response.
 * 
 * @author thutrang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String code;
    private String message;
}
