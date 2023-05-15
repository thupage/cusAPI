package com.api.customer.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
@Component
public class CustomerRepository {

    @Autowired
    private CustomerMapper customerMapper;

    public List<CustomerEntity> getListAllOfCustomer(SearchRequest searchRequest) {
        return this.customerMapper.getListOfCustomer(searchRequest);
    }

    public int countCustomer(CustomerEntity customerEntity) {
        return this.customerMapper.countCustomer(customerEntity);
    }
}
