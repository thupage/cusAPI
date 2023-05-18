package com.api.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * District Entity.
 * 
 * @author thutrang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictEntity {
    private int districtId;
    private String districtName;
}
