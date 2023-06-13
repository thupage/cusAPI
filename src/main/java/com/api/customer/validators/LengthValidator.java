package com.api.customer.validators;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.api.customer.annotations.LengthConstraint;
import com.api.customer.model.response.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Length Validator.
 * 
 * @author thutrang
 */
public class LengthValidator implements ConstraintValidator<LengthConstraint, String> {

    private String code;
    private String message;
    private int min;
    private int max;

    @Autowired
    private MessageSource messageSource;

    @Override
    public void initialize(LengthConstraint lengthConstraint) {
        this.code = lengthConstraint.code();
        this.message = lengthConstraint.message();
        this.min = lengthConstraint.min();
        this.max = lengthConstraint.max();
    }

    @Override
    public boolean isValid(String value,
            ConstraintValidatorContext cxt) {
        ErrorResponse customError = new ErrorResponse();
        customError.setCode(code);
        customError.setMessage(messageSource.getMessage(message, new Object[] { max }, Locale.ENGLISH));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonError;
        try {
            jsonError = objectMapper.writeValueAsString(customError);
        } catch (JsonProcessingException e) {
            jsonError = "";
        }
        cxt.disableDefaultConstraintViolation();
        cxt.buildConstraintViolationWithTemplate(jsonError).addConstraintViolation();
        if (value == null) {
            return true;
        }
        int length = value.length();
        return length >= min && length <= max;
    }
}
