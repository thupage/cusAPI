package com.api.customer.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.customer.entities.CustomerEntity;
import com.api.customer.mappers.CustomerMapper;
import com.api.customer.model.request.SearchRequest;

/**
 * Customer Repository.
 * 
 * @author thutrang
 */
@Repository
public class CustomerRepository {

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerRepository(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    /**
     * Returns a list of all customers based on the search query.
     * 
     * @param searchRequest The object of the search request.
     * @return List of clients found.
     */
    public List<CustomerEntity> getListAllOfCustomer(SearchRequest searchRequest) {
        return customerMapper.getListOfCustomer(searchRequest);
    }

    /**
     * Count the number of customers based on the search request.
     * 
     * @param searchRequest The object of the search request.
     * @return Number of clients found.
     */
    public int countCustomer(SearchRequest searchRequest) {
        return customerMapper.countCustomer(searchRequest);
    }
}
