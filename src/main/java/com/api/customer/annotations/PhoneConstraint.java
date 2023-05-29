package com.api.customer.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.api.customer.validators.PhoneValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * Phone Constraint.
 * 
 * @author thutrang
 */
@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneConstraint {

    String message() default "";

    String code() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
