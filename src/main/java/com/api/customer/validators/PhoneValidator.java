package com.api.customer.validators;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.api.customer.annotations.PhoneConstraint;
import com.api.customer.model.response.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Phone Validator.
 * 
 * @author thutrang
 */
public class PhoneValidator implements ConstraintValidator<PhoneConstraint, String> {

    private String code;
    private String message;

    @Autowired
    private MessageSource messageSource;

    @Override
    public void initialize(PhoneConstraint phoneConstraint) {
        this.code = phoneConstraint.code();
        this.message = phoneConstraint.message();
    }

    @Override
    public boolean isValid(String phone,
            ConstraintValidatorContext cxt) {
        ErrorResponse customError = new ErrorResponse();
        customError.setCode(code);
        customError.setMessage(messageSource.getMessage(message, new Object[] { "Phone Number" }, Locale.ENGLISH));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonError;
        try {
            jsonError = objectMapper.writeValueAsString(customError);
        } catch (JsonProcessingException e) {
            jsonError = "";
        }
        cxt.disableDefaultConstraintViolation();
        cxt.buildConstraintViolationWithTemplate(jsonError).addConstraintViolation();
        return phone != null && phone.matches("\\d+")
                && (phone.length() > 8) && (phone.length() < 12);
    }
}
