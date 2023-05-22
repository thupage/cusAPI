package com.api.customer.model.request;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * The UpdateRequest object contains the request update profile.
 * 
 * @author thutrang
 */
@Data
public class UpdateRequest {
    private int customerId;

    // @NotEmpty
    @Length(max = 60)
    private String firstName;

    // @NotEmpty
    @Length(max = 60)
    private String lastName;

    // @NotEmpty
    @Length(max = 24)
    private String idCardNo;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @NotEmpty
    // @Pattern(regexp = "male" + "female" + "other")
    private String gender;

    @NotEmpty
    @Length(min = 10, max = 11)
    private String phone;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Length(max = 60)
    private String street;

    @NotEmpty
    private String nationality;

    @NotEmpty
    private String occupation;

    @NotEmpty
    @Length(max = 24)
    private String passportNo;

    @NotEmpty
    private String wardId;
    private String married;
}
