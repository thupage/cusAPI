package com.api.customer.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.api.customer.entities.CustomerEntity;
import com.api.customer.exceptions.ExceptionResponse;
import com.api.customer.mappers.CustomerMapper;
import com.api.customer.model.request.SearchRequest;
import com.api.customer.model.response.CustomerResponse;

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
     * 
     * @param searchRequest
     * @return
     */
    public List<CustomerResponse> getListAllOfCustomer(SearchRequest searchRequest) {
        return customerMapper.getListOfCustomer(searchRequest);
    }

    /**
     * Returns a list of all customers based on the search query.
     * 
     * @param searchRequest The object of the search request.
     * @return List of clients found.
     */
    public int countCustomer(SearchRequest searchRequest) {
        return customerMapper.countCustomer(searchRequest);
    }

    /**
     * Get details of a customer based on customer ID.
     * 
     * @param customerId ID of the customer to get details.
     * @return The CustomerEntity object contains the customer's details.
     */
    public CustomerEntity getDetailOfCustomerById(int customerId) {
        return customerMapper.getDetailOfCustomer(customerId);
    }

    /**
     * Check the existence of a customer based on the customer ID.
     * 
     * @param customerId ID of the customer to check.
     * @return true if customer exists, false if not.
     */
    public Boolean customerIdExist(int customerId) {
        return customerMapper.getDetailOfCustomer(customerId) != null;
    }

    public ResponseEntity<ExceptionResponse> updateCustomerStatus(CustomerEntity customerEntity) {
        return customerMapper.updateCustomerStatus(customerEntity);
    }
}
