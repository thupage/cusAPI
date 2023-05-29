package com.api.customer.model.request;

import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_REQUIRED;

import com.api.customer.annotations.EmailConstraint;
import com.api.customer.annotations.LengthConstraint;
import com.api.customer.annotations.NotEmptyConstraint;
import com.api.customer.annotations.PatternConstraint;
import com.api.customer.annotations.PhoneConstraint;

import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_MAXLENGTH;
import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_INVALID;
import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_INVALID_FORMAT;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_PHONE_INVALID;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_FIRST_NAME_REQUIRED;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_FIRST_NAME_MAXLENGTH;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_LAST_NAME_REQUIRED;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_LAST_NAME_MAXLENGTH;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_ID_CARD_NO_REQUIRED;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_ID_CARD_NO_MAXLENGTH;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_DOB_INVALID;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_DOB_REQUIRED;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_GENDER_REQUIRED;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_GENDER_INVALID;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_PHONE_REQUIRED;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_EMAIL_REQUIRED;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_EMAIL_INVALID;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_STREET_REQUIRED;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_STREET_MAXLENGTH;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_WARD_REQUIRED;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_NATIONALITY_REQUIRED;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_OCCUPATION_REQUIRED;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_PASSPORT_NO_REQUIRED;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_PASSPORT_NO_MAXLENGTH;

import lombok.Data;

/**
 * The UpdateRequest object contains the request update profile.
 * 
 * @author thutrang
 */
@Data
public class UpdateRequest {

    private int customerId;

    @NotEmptyConstraint(message = ERROR_MESSAGE_IS_REQUIRED, code = ERROR_CODE_FIRST_NAME_REQUIRED)
    @LengthConstraint(max = 60, message = ERROR_MESSAGE_IS_MAXLENGTH, code = ERROR_CODE_FIRST_NAME_MAXLENGTH)
    private String firstName;

    @NotEmptyConstraint(message = ERROR_MESSAGE_IS_REQUIRED, code = ERROR_CODE_LAST_NAME_REQUIRED)
    @LengthConstraint(max = 60, message = ERROR_MESSAGE_IS_MAXLENGTH, code = ERROR_CODE_LAST_NAME_MAXLENGTH)
    private String lastName;

    @NotEmptyConstraint(message = ERROR_MESSAGE_IS_REQUIRED, code = ERROR_CODE_ID_CARD_NO_REQUIRED)
    @LengthConstraint(max = 24, message = ERROR_MESSAGE_IS_MAXLENGTH, code = ERROR_CODE_ID_CARD_NO_MAXLENGTH)
    private String idCardNo;

    @NotEmptyConstraint(message = ERROR_MESSAGE_IS_REQUIRED, code = ERROR_CODE_DOB_REQUIRED)
    @PatternConstraint(regexp = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$", message = ERROR_MESSAGE_IS_INVALID, code = ERROR_CODE_DOB_INVALID, field = "Dob")
    private String dob;

    @NotEmptyConstraint(message = ERROR_MESSAGE_IS_REQUIRED, code = ERROR_CODE_GENDER_REQUIRED)
    @PatternConstraint(regexp = "^(male|female|other)$", message = ERROR_MESSAGE_IS_INVALID, code = ERROR_CODE_GENDER_INVALID, field = "Gender")
    private String gender;

    @NotEmptyConstraint(message = ERROR_MESSAGE_IS_REQUIRED, code = ERROR_CODE_PHONE_REQUIRED)
    @PhoneConstraint(message = ERROR_MESSAGE_IS_INVALID_FORMAT, code = ERROR_CODE_PHONE_INVALID)
    private String phone;

    @NotEmptyConstraint(message = ERROR_MESSAGE_IS_REQUIRED, code = ERROR_CODE_EMAIL_REQUIRED)
    @EmailConstraint(message = ERROR_MESSAGE_IS_INVALID_FORMAT, code = ERROR_CODE_EMAIL_INVALID)
    private String email;

    @NotEmptyConstraint(message = ERROR_MESSAGE_IS_REQUIRED, code = ERROR_CODE_STREET_REQUIRED)
    @LengthConstraint(max = 60, message = ERROR_MESSAGE_IS_MAXLENGTH, code = ERROR_CODE_STREET_MAXLENGTH)
    private String street;

    @NotEmptyConstraint(message = ERROR_MESSAGE_IS_REQUIRED, code = ERROR_CODE_NATIONALITY_REQUIRED)
    private String nationality;

    @NotEmptyConstraint(message = ERROR_MESSAGE_IS_REQUIRED, code = ERROR_CODE_OCCUPATION_REQUIRED)
    private String occupation;

    @NotEmptyConstraint(message = ERROR_MESSAGE_IS_REQUIRED, code = ERROR_CODE_PASSPORT_NO_REQUIRED)
    @LengthConstraint(max = 24, message = ERROR_MESSAGE_IS_MAXLENGTH, code = ERROR_CODE_PASSPORT_NO_MAXLENGTH)
    private String passportNo;

    @NotEmptyConstraint(message = ERROR_MESSAGE_IS_REQUIRED, code = ERROR_CODE_WARD_REQUIRED)
    private String wardId;
    private String married;
}
