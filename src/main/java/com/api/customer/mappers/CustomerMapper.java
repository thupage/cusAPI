package com.api.customer.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.api.customer.entities.CustomerEntity;
import com.api.customer.model.request.SearchRequest;
import com.api.customer.model.response.CustomerResponse;

/**
 * Customer Mapper.
 * 
 * @author thutrang
 */
@Mapper
public interface CustomerMapper {

    /**
     * Returns a list of customers based on the search query.
     * 
     * @param searchRequest The object of the search request.
     * @return List of clients found.
     */
    public List<CustomerResponse> getListOfCustomer(@Param("searchRequest") SearchRequest searchRequest);

    /**
     * Count the number of customers based on the search request.
     * 
     * @param searchRequest The object of the search request.
     * @return Number of clients found.
     */
    public int countCustomer(@Param("searchRequest") SearchRequest searchRequest);

    /**
     * Get details of a customer based on customer ID.
     * 
     * @param customerId ID of the customer to get details.
     * @return The CustomerEntity object contains the customer's details.
     */
    public CustomerEntity getDetailOfCustomer(@Param("customerId") int customerId);

    /**
     * Update client status
     * 
     * @param customerId ID of the customer to update batch.
     * @param status     New customer's status.
     */
    public void batchUpdateCustomerStatus(@Param("customerId") int customerId, @Param("status") String status);

}
