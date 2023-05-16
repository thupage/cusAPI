package com.api.customer.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.customer.entities.CustomerEntity;
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

    public List<CustomerResponse> getListAllOfCustomer(SearchRequest searchRequest) {
        return customerMapper.getListOfCustomer(searchRequest);
    }

    public int countCustomer(SearchRequest searchRequest) {
        return customerMapper.countCustomer(searchRequest);
    }

    public CustomerEntity getDetailOfCustomerById(int customerId) {
        return customerMapper.getDetailOfCustomer(customerId);
    }

    public Boolean customerIdExist(int customerId) {
        return customerMapper.getDetailOfCustomer(customerId) != null;
    }
}
