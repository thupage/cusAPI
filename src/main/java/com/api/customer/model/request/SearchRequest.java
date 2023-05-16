package com.api.customer.model.request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The SearchRequest object contains the search information.
 * 
 * @author thutrang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    private String firstName;
    private String lastName;
    private String idCardNo;
    private Date dobStartDate;
    private Date dobEndDate;
    private String phone;
    private String email;
    private String street;
    private int wardId;
    private int districtId;
    private int provinceId;
    private int agencyId;
    private int page;
    private int itemPerPage;
}
