package com.api.customer.model.response;

import com.api.customer.entities.AddressEntity;
import com.api.customer.entities.AgencyEntity;
import com.api.customer.entities.NationalityEntity;
import com.api.customer.entities.OccupationEntity;

import lombok.Data;

/**
 * Customer Response.
 * 
 * @author thutrang
 */
@Data
public class CustomerResponse {
    private int customerId;
    private String firstName;
    private String lastName;
    private String idCardNo;
    private String dob;
    private String gender;
    private String phone;
    private String email;
    private String userName;
    private String status;
    private AddressEntity address;
    private NationalityEntity nationality;
    private OccupationEntity occupation;
    private String married;
    private String passportNo;
    private AgencyEntity agency;
}
