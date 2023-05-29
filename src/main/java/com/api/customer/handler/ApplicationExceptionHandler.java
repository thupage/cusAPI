package com.api.customer.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.customer.exceptions.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Application ExceptionHandler.
 * 
 * @author thutrang
 */
@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, List<ErrorResponse>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ErrorResponse> errors = new ArrayList<>();
        Map<String, List<ErrorResponse>> errorResponse = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorResponse customError;
            try {
                customError = objectMapper.readValue(error.getDefaultMessage(), ErrorResponse.class);
            } catch (JsonProcessingException e) {
                customError = null;
            }
            errors.add(customError);
        });
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}
