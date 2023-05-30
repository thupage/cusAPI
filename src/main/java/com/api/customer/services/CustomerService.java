package com.api.customer.services;

import java.util.List;
import java.util.Locale;

import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_NOT_FOUND;
import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_STATUS_INVALID;
import static com.api.customer.constants.SuccessMessage.SUCCESS_MESSAGE;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_CUSTOMER_ID_NOT_FOUND;
import static com.api.customer.constants.ErrorCodes.ERROR_CODE_STATUS_INVALID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.customer.entities.CustomerEntity;
import com.api.customer.exceptions.BadRequestException;
import com.api.customer.exceptions.ErrorResponse;
import com.api.customer.exceptions.IdNotFoundException;
import com.api.customer.model.request.SearchRequest;
import com.api.customer.model.request.UpdateRequest;
import com.api.customer.model.response.CustomerResponse;
import com.api.customer.model.response.MessageResponse;
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

    /**
     * Returns a list of customers based on the search query.
     * 
     * @param searchRequest The object of the search request.
     * @return The SearchResponse object contains the customer search results.
     */
    public SearchResponse getAllOfCustomer(SearchRequest searchRequest) {
        searchRequest.setOffset((searchRequest.getPage() - 1) * searchRequest.getItemPerPage());
        List<CustomerResponse> customerResponses = this.customerRepository.getListAllOfCustomer(searchRequest);
        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setItemCount(this.customerRepository.countCustomer(searchRequest));
        searchResponse.setResult(customerResponses);
        return searchResponse;
    }

    /**
     * Get details of a customer based on customer ID.
     * 
     * @param customerId ID of the customer to get details.
     * @return The CustomerEntity object contains the customer's details.
     * @throws IdNotFoundException If the client ID does not exist.
     */
    public CustomerEntity getCustomerDetailById(int customerId) {
        if (!customerRepository.isNotFound(customerId)) {
            logger.error(messageSource.getMessage(ERROR_MESSAGE_IS_NOT_FOUND, null, Locale.ENGLISH));
            throw new IdNotFoundException(new ErrorResponse(ERROR_CODE_CUSTOMER_ID_NOT_FOUND,
                    messageSource.getMessage(ERROR_MESSAGE_IS_NOT_FOUND, null, Locale.ENGLISH)));
        }
        CustomerEntity customerEntity = this.customerRepository.getDetailOfCustomerById(customerId);
        return customerEntity;
    }

    /**
     * Update client status.
     * 
     * @param customerId ID of the customer to update.
     * @param status     New customer's status.
     * @return The success message.
     * @throws IdNotFoundException If the client ID does not exist.
     * @throws BadRequestException If customer's status invalid.
     */
    public MessageResponse updateCustomersStatus(int customerId, String status) {
        if (!customerRepository.isNotFound(customerId)) {
            logger.error(messageSource.getMessage(ERROR_MESSAGE_IS_NOT_FOUND, null, Locale.ENGLISH));
            throw new IdNotFoundException(new ErrorResponse(ERROR_CODE_CUSTOMER_ID_NOT_FOUND,
                    messageSource.getMessage(ERROR_MESSAGE_IS_NOT_FOUND, null, Locale.ENGLISH)));
        }
        if (!customerRepository.isBadRequest(status)) {
            logger.error(messageSource.getMessage(ERROR_MESSAGE_IS_STATUS_INVALID, null, Locale.ENGLISH));
            throw new BadRequestException(new ErrorResponse(ERROR_CODE_STATUS_INVALID,
                    messageSource.getMessage(ERROR_MESSAGE_IS_STATUS_INVALID, null, Locale.ENGLISH)));
        }
        customerRepository.batchUpdateCustomerStatus(customerId, status);
        return new MessageResponse(messageSource.getMessage(SUCCESS_MESSAGE, null, Locale.ENGLISH));
    }

    /**
     * Update client's temporary profile information.
     * 
     * @param updateRequest The UpdateRequest object contains the profile update
     *                      information.
     * @return The success message.
     * @throws IdNotFoundException If the client ID does not exist.
     */
    public MessageResponse updateRequestProfile(UpdateRequest updateRequest) {
        if (!customerRepository.isNotFound(updateRequest.getCustomerId())) {
            logger.error(messageSource.getMessage(ERROR_MESSAGE_IS_NOT_FOUND, null, Locale.ENGLISH));
            throw new IdNotFoundException(new ErrorResponse(ERROR_CODE_CUSTOMER_ID_NOT_FOUND,
                    messageSource.getMessage(ERROR_MESSAGE_IS_NOT_FOUND, null, Locale.ENGLISH)));
        }
        this.customerRepository.requestUpdateProfile(updateRequest, updateRequest.getCustomerId());
        return new MessageResponse(
                messageSource.getMessage(SUCCESS_MESSAGE, new Object[] { "Update" }, Locale.ENGLISH));
    }

    /**
     * Delete a customer based on customer ID.
     * 
     * @param customerId ID of the customer to delete.
     * @return Delete success.
     */
    public MessageResponse deleteCustomer(int customerId) {
        if (!customerRepository.isNotFound(customerId)) {
            logger.error(messageSource.getMessage(ERROR_MESSAGE_IS_NOT_FOUND, null, Locale.ENGLISH));
            throw new IdNotFoundException(new ErrorResponse(ERROR_CODE_CUSTOMER_ID_NOT_FOUND,
                    messageSource.getMessage(ERROR_MESSAGE_IS_NOT_FOUND, null, Locale.ENGLISH)));
        }
        this.customerRepository.deleteCustomer(customerId);
        return new MessageResponse(
                messageSource.getMessage(SUCCESS_MESSAGE, new Object[] { "Delete" }, Locale.ENGLISH));
    }
}