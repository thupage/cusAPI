package com.api.customer.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.api.customer.entities.CustomerEntity;
import com.api.customer.model.request.SearchRequest;

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
    public List<CustomerEntity> getListOfCustomer(@Param("searchRequest") SearchRequest searchRequest);

    /**
     * Count the number of customers based on the search request.
     * 
     * @param searchRequest The object of the search request.
     * @return Number of clients found.
     */
    public int countCustomer(@Param("searchRequest") SearchRequest searchRequest);

}
