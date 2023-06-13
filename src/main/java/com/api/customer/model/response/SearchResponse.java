package com.api.customer.model.response;

import java.util.List;

import lombok.Data;

/**
 * The SearchResponse object contains the search results.
 * 
 * @author thutrang
 */
@Data
public class SearchResponse {
    private int itemCount;
    private List<CustomerResponse> result;
}
