package com.api.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.customer.entities.CustomerEntity;
import com.api.customer.model.request.SearchRequest;
import com.api.customer.model.response.SearchResponse;
import com.api.customer.repositories.CustomerRepository;

/**
 * Customer Service.
 * 
 * @author thutrang
 */
@Service
@Component
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Returns a list of customers based on the search query.
     * 
     * @param searchRequest The object of the search request.
     * @return The SearchResponse object contains the customer search results.
     */
    public SearchResponse getAllOfCustomer(SearchRequest searchRequest) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(searchRequest.getFirstName());
        customerEntity.setLastName(searchRequest.getLastName());
        customerEntity.setIdCardNo(searchRequest.getIdCardNo());
        customerEntity.setPhone(searchRequest.getPhone());
        customerEntity.setEmail(searchRequest.getEmail());

        List<CustomerEntity> customerEntities = this.customerRepository.getListAllOfCustomer(searchRequest);
        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setItemCount(this.customerRepository.countCustomer(searchRequest));
        searchResponse.setResult(customerEntities);
        return searchResponse;
    }
}
