package com.api.customer.model.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.api.customer.entities.CustomerEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Search Response.
 * 
 * @author thutrang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SearchResponse {
    private int itemCount;
    private List<CustomerEntity> result;
}
