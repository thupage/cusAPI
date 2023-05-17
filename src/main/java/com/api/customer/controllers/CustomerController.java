package com.api.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.customer.entities.CustomerEntity;
import com.api.customer.model.request.SearchRequest;
import com.api.customer.model.response.SearchResponse;
import com.api.customer.services.CustomerService;

import jakarta.validation.Valid;

/**
 * Customer Controller.
 * 
 * @author thutrang
 */
@RestController
@Validated
@RequestMapping("/management")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Get a list of customers base on the search query.
     * 
     * @param searchRequest The request object looks for the client.
     * @return ResponseEntity contains a SearchResponse object in the response body.
     */
    @GetMapping(value = "/customer")
    public ResponseEntity<SearchResponse> getAllOfCustomers(@Valid @RequestBody SearchRequest searchRequest) {
        return ResponseEntity.ok(customerService.getAllOfCustomer(searchRequest));
    }

    /**
     * Get details of a customer based on customer ID.
     * 
     * @param customerId ID of the customer to get details.
     * @return ResponseEntity contains a CustomerEntity object in the response body.
     */
    @GetMapping(value = "/customer/{customerId}")
    public ResponseEntity<CustomerEntity> getSalaryDetailsById(@Valid @PathVariable int customerId) {
        return ResponseEntity.ok(customerService.getCustomerDetailById(customerId));
    }
}
