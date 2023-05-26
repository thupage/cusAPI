package com.api.customer.annotation;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.api.customer.exceptions.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEmptyValidator implements ConstraintValidator<NotEmptyConstraint, String> {

    private String code;
    private String message;

    @Autowired
    private MessageSource messageSource;

    @Override
    public void initialize(NotEmptyConstraint notEmptyConstraint) {
        this.code = notEmptyConstraint.code();
        this.message = notEmptyConstraint.message();
    }

    @Override
    public boolean isValid(String value,
            ConstraintValidatorContext cxt) {
        ErrorResponse customError = new ErrorResponse();
        customError.setCode(code);
        customError.setMessage(messageSource.getMessage(message, null, Locale.ENGLISH));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonError;
        try {
            jsonError = objectMapper.writeValueAsString(customError);
        } catch (JsonProcessingException e) {
            jsonError = "";
        }
        cxt.disableDefaultConstraintViolation();
        cxt.buildConstraintViolationWithTemplate(jsonError).addConstraintViolation();
        return !(value == null || value.isEmpty());
    }
}
