package com.api.customer.model.request;

import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_REQUIRED;
import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_MAXLENGTH_60;
import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_MAXLENGTH_24;
import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_DOB_INVALID;
import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_GENDER_INVALID;
import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_PHONE_INVALID;
import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_EMAIL_INVALID;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_PHONE_INVALID;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * The UpdateRequest object contains the request update profile.
 * 
 * @author thutrang
 */
@Data
public class UpdateRequest {

    private int customerId;

    @NotEmpty(message = ERROR_MESSAGE_IS_REQUIRED)
    @Length(max = 60, message = ERROR_MESSAGE_IS_MAXLENGTH_60)
    private String firstName;

    @NotEmpty(message = ERROR_MESSAGE_IS_REQUIRED)
    @Length(max = 60, message = ERROR_MESSAGE_IS_MAXLENGTH_60)
    private String lastName;

    @NotEmpty(message = ERROR_MESSAGE_IS_REQUIRED)
    @Length(max = 24, message = ERROR_MESSAGE_IS_MAXLENGTH_24)
    private String idCardNo;

    @NotNull(message = ERROR_MESSAGE_IS_REQUIRED)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @NotEmpty(message = ERROR_MESSAGE_IS_REQUIRED)
    @Pattern(regexp = "^(male|female|other)$", message = ERROR_MESSAGE_IS_GENDER_INVALID)
    private String gender;

    @NotEmpty(message = ERROR_MESSAGE_IS_REQUIRED)
    // @PhoneConstraint(message = ERROR_MESSAGE_IS_PHONE_INVALID, code = ERROR_CODE_PHONE_INVALID)
    private String phone;

    @NotEmpty(message = ERROR_MESSAGE_IS_REQUIRED)
    @Email(message = ERROR_MESSAGE_IS_EMAIL_INVALID)
    private String email;

    @NotEmpty(message = ERROR_MESSAGE_IS_REQUIRED)
    @Length(max = 60, message = ERROR_MESSAGE_IS_MAXLENGTH_60)
    private String street;

    @NotEmpty(message = ERROR_MESSAGE_IS_REQUIRED)
    private String nationality;

    @NotEmpty(message = ERROR_MESSAGE_IS_REQUIRED)
    private String occupation;

    @NotEmpty(message = ERROR_MESSAGE_IS_REQUIRED)
    @Length(max = 24, message = ERROR_MESSAGE_IS_MAXLENGTH_24)
    private String passportNo;

    @NotEmpty(message = ERROR_MESSAGE_IS_REQUIRED)
    private String wardId;
    private String married;
}
