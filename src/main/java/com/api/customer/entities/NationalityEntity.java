package com.api.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Nationality Entity.
 * 
 * @author thutrang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NationalityEntity {
    private int nationalityId;
    private String nationalityName;
}
