package com.api.customer.annotation;

import java.util.Locale;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.api.customer.exceptions.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

    private String code;
    private String message;
    private String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Autowired
    private MessageSource messageSource;

    @Override
    public void initialize(EmailConstraint emailConstraint) {
        this.code = emailConstraint.code();
        this.message = emailConstraint.message();
    }

    @Override
    public boolean isValid(String email,
            ConstraintValidatorContext cxt) {
        ErrorResponse customError = new ErrorResponse();
        customError.setCode(code);
        customError.setMessage(messageSource.getMessage(message, new Object[] { "Email" }, Locale.ENGLISH));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonError;
        try {
            jsonError = objectMapper.writeValueAsString(customError);
        } catch (JsonProcessingException e) {
            jsonError = "";
        }
        cxt.disableDefaultConstraintViolation();
        cxt.buildConstraintViolationWithTemplate(jsonError).addConstraintViolation();
        if (StringUtils.isBlank(email))
            return true;
        Pattern pat = Pattern.compile(regex);
        return pat.matcher(email).matches();
    }
}
