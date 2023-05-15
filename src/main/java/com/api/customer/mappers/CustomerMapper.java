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

    public List<CustomerEntity> getListOfCustomer(@Param("searchRequest") SearchRequest searchRequest);

    public int countCustomer(@Param("customerEntity") CustomerEntity customerEntity);

}
