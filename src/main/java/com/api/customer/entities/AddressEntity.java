package com.api.customer.entities;

import lombok.Data;

/**
 * Address Entity.
 * 
 * @author thutrang
 */
@Data
public class AddressEntity {
    private String street;
    private WardEntity ward;
    private DistrictEntity district;
    private ProvinceEntity province;
}
