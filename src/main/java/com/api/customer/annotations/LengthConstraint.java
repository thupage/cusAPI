package com.api.customer.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.api.customer.validators.LengthValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * Length Constraint.
 * 
 * @author thutrang
 */
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LengthValidator.class)
public @interface LengthConstraint {

    int min() default 0;

    int max() default Integer.MAX_VALUE;

    String message() default "";

    String code() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
