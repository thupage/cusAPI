package com.api.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * Get a list of customers based on the search query.
     * 
     * @param searchRequest The request object looks for the client.
     * @return ResponseEntity contains a SearchResponse object in the response body.
     */
    @GetMapping(value = "/customer")
    public ResponseEntity<SearchResponse> getAllOfCustomers(@Valid @RequestBody SearchRequest searchRequest) {
        return ResponseEntity.ok(customerService.getAllOfCustomer(searchRequest));
    }
}
