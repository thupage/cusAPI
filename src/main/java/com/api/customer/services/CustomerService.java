package com.api.customer.services;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_CUSTOMER_ID_NOT_FOUND;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_CUSTOMER_ID_NOT_FOUND;
import com.api.customer.entities.AddressEntity;
import com.api.customer.entities.AgencyEntity;
import com.api.customer.entities.CustomerEntity;
import com.api.customer.entities.DistrictEntity;
import com.api.customer.entities.ProvinceEntity;
import com.api.customer.entities.WardEntity;
import com.api.customer.exceptions.ExceptionResponse;
import com.api.customer.exceptions.IdNotFoundException;
import com.api.customer.model.request.SearchRequest;
import com.api.customer.model.response.CustomerResponse;
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

    @Autowired
    private MessageSource messageSource;

    private static Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public SearchResponse getAllOfCustomer(SearchRequest searchRequest) {
        CustomerResponse customerResponse = new CustomerResponse();
        AddressEntity addressEntity = new AddressEntity();
        WardEntity wardEntity = new WardEntity();
        DistrictEntity districtEntity = new DistrictEntity();
        ProvinceEntity provinceEntity = new ProvinceEntity();
        AgencyEntity agencyEntity = new AgencyEntity();
        customerResponse.setFirstName(searchRequest.getFirstName());
        customerResponse.setLastName(searchRequest.getLastName());
        customerResponse.setIdCardNo(searchRequest.getIdCardNo());
        customerResponse.setPhone(searchRequest.getPhone());
        customerResponse.setEmail(searchRequest.getEmail());
        addressEntity.setStreet(searchRequest.getStreet());
        wardEntity.setWardId(searchRequest.getWardId());
        districtEntity.setDistrictId(searchRequest.getDistrictId());
        provinceEntity.setProvinceId(searchRequest.getProvinceId());
        agencyEntity.setAgencyId(searchRequest.getAgencyId());
        List<CustomerResponse> customerResponses = this.customerRepository.getListAllOfCustomer(searchRequest);
        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setItemCount(this.customerRepository.countCustomer(searchRequest));
        searchResponse.setResult(customerResponses);
        return searchResponse;
    }

    public CustomerEntity getCustomerDetailById(int customerId) {
        if (!customerRepository.customerIdExist(customerId)) {
            logger.error(messageSource.getMessage(ERROR_MESSAGE_CUSTOMER_ID_NOT_FOUND, null, Locale.ENGLISH));
            throw new IdNotFoundException(new ExceptionResponse(ERROR_CODE_CUSTOMER_ID_NOT_FOUND,
                    messageSource.getMessage(ERROR_MESSAGE_CUSTOMER_ID_NOT_FOUND, null, Locale.ENGLISH)));
        }
        CustomerEntity customerEntity = this.customerRepository.getDetailOfCustomerById(customerId);
        return customerEntity;
    }
}
