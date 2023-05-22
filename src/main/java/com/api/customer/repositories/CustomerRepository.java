package com.api.customer.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.customer.entities.CustomerEntity;
import com.api.customer.mappers.CustomerMapper;
import com.api.customer.model.request.SearchRequest;
import com.api.customer.model.request.UpdateRequest;
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

    List<String> newStatus = Arrays.asList("lock", "unlock");

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
    public Boolean isNotFound(int customerId) {
        return customerMapper.getDetailOfCustomer(customerId) != null;
    }

    /**
     * Check the valid of a customer based on the status.
     * 
     * @param status Status of the customer to check.
     * @return true if status valid, false if invalid.
     */
    public Boolean isBadRequest(String status) {
        return newStatus.contains(status);
    }

    /**
     * Batch update customer's status on customer ID.
     * 
     * @param customerId ID of the customer to update batch.
     * @param status     New customer's status.
     */
    public void batchUpdateCustomerStatus(int customerId, String status) {
        customerMapper.batchUpdateCustomerStatus(customerId, status);
    }

    public int requestUpdateProfile(UpdateRequest updateRequest, int customerId) {
        return customerMapper.updateProfile(updateRequest, customerId);
    }
}
