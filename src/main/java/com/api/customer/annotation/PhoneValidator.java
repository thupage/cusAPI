// package com.api.customer.annotation;

// import jakarta.validation.ConstraintValidator;
// import jakarta.validation.ConstraintValidatorContext;

// public class PhoneValidator implements ConstraintValidator<PhoneConstraint, String> {

// //     private String code;

// //     @Override
// //     public void initialize(PhoneConstraint contactNumber) {
// //         this.code = contactNumber.code();
// //     }

// //     @Override
// //     public boolean isValid(String contactField,
// //             ConstraintValidatorContext cxt) {
// // cxt.buildConstraintViolationWithTemplate("contactField").addConstraintViolation();
// // cxt.getDefaultConstraintMessageTemplate().
// //         return contactField != null && contactField.matches("\\d+")
// //                 && (contactField.length() > 8) && (contactField.length() < 12);
// //     }
// }
