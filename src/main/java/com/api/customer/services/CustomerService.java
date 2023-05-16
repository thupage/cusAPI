package com.api.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.customer.entities.AddressEntity;
import com.api.customer.entities.AgencyEntity;
import com.api.customer.entities.CustomerEntity;
import com.api.customer.entities.DistrictEntity;
import com.api.customer.entities.ProvinceEntity;
import com.api.customer.entities.WardEntity;
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

    public SearchResponse getAllOfCustomer(SearchRequest searchRequest) {
        CustomerEntity customerEntity = new CustomerEntity();
        // AddressEntity addressEntity = new AddressEntity();
        // WardEntity wardEntity = new WardEntity();
        // DistrictEntity districtEntity = new DistrictEntity();
        // ProvinceEntity provinceEntity = new ProvinceEntity();
        // AgencyEntity agencyEntity = new AgencyEntity();
        // customerEntity.setFirstName(searchRequest.getFirstName());
        // customerEntity.setLastName(searchRequest.getLastName());
        // customerEntity.setIdCardNo(searchRequest.getIdCardNo());
        // customerEntity.setPhone(searchRequest.getPhone());
        // customerEntity.setEmail(searchRequest.getEmail());
        // addressEntity.setStreet(searchRequest.getStreet());
        // wardEntity.setWardId(searchRequest.getWardId());
        // districtEntity.setDistrictId(searchRequest.getDistrictId());
        // provinceEntity.setProvinceId(searchRequest.getProvinceId());
        // agencyEntity.setAgencyId(searchRequest.getAgencyId());
        List<CustomerEntity> customerEntities = this.customerRepository.getListAllOfCustomer(searchRequest);
        // Mapper mapper = new Mapper(customerEntities);
        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setItemCount(this.customerRepository.countCustomer(customerEntity));
        searchResponse.setResult(customerEntities);
        return searchResponse;
    }
}
