package com.api.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Address Entity.
 * 
 * @author thutrang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    private String street;
    private WardEntity ward;
    private DistrictEntity district;
    private ProvinceEntity province;
}
