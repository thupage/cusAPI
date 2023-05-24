package com.api.customer.annotation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.util.Strings;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<DateConstraint, String> {

    private Boolean isOptional;

    @Override
    public void initialize(DateConstraint dateConstraint) {
        this.isOptional = dateConstraint.optional();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        boolean validDate = isValidFormat("yyyy/MM/dd", value);

        return isOptional ? (validDate || (Strings.isNotEmpty(value))) : validDate;
    }

    private static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            if (value != null) {
                date = sdf.parse(value);
                if (!value.equals(sdf.format(date))) {
                    date = null;
                }
            }
        } catch (ParseException ex) {
        }
        return date != null;
    }
}
