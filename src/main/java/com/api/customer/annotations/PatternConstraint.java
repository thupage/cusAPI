package com.api.customer.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.api.customer.validators.PatternValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * Pattern Constraint.
 * 
 * @author thutrang
 */
@Documented
@Constraint(validatedBy = PatternValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PatternConstraint {

    String message() default "";

    String code() default "";

    String field() default "";

    String regexp();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
