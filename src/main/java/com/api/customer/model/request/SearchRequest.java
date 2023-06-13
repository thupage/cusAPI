package com.api.customer.model.request;

import lombok.Data;

/**
 * The SearchRequest object contains the search information.
 * 
 * @author thutrang
 */
@Data
public class SearchRequest {
    private String firstName;
    private String lastName;
    private String idCardNo;
    private String dobStartDate;
    private String dobEndDate;
    private String phone;
    private String email;
    private String street;
    private int wardId;
    private int districtId;
    private int provinceId;
    private int agencyId;
    private int page;
    private int itemPerPage;
    private int offset;
}
