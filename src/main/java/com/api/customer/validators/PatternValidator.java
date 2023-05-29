package com.api.customer.validators;

import java.util.Locale;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.api.customer.annotations.PatternConstraint;
import com.api.customer.exceptions.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Pattern Validator.
 * 
 * @author thutrang
 */
public class PatternValidator implements ConstraintValidator<PatternConstraint, String> {

    private String code;
    private String message;
    private String field;
    private String regexp;

    @Autowired
    private MessageSource messageSource;

    @Override
    public void initialize(PatternConstraint patternConstraint) {
        this.code = patternConstraint.code();
        this.message = patternConstraint.message();
        this.field = patternConstraint.field();
        this.regexp = patternConstraint.regexp();
    }

    @Override
    public boolean isValid(String value,
            ConstraintValidatorContext cxt) {
        ErrorResponse customError = new ErrorResponse();
        customError.setCode(code);
        customError.setMessage(messageSource.getMessage(message, new Object[] { field }, Locale.ENGLISH));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonError;
        try {
            jsonError = objectMapper.writeValueAsString(customError);
        } catch (JsonProcessingException e) {
            jsonError = "";
        }
        cxt.disableDefaultConstraintViolation();
        cxt.buildConstraintViolationWithTemplate(jsonError).addConstraintViolation();
        Pattern pattern = Pattern.compile(regexp);
        return pattern.matcher(value).matches();
    }
}
