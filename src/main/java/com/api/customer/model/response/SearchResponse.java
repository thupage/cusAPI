package com.api.customer.model.response;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The SearchResponse object contains the search results.
 * 
 * @author thutrang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SearchResponse {
    private int itemCount;
    private List<CustomerResponse> result;
}
