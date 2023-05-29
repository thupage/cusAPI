package com.api.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Customer Entity.
 * 
 * @author thutrang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
