package com.api.customer.entities;

import lombok.Data;

/**
 * Customer Entity.
 * 
 * @author thutrang
 */
@Data
public class CustomerEntity {
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
