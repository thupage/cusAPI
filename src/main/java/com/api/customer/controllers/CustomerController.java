package com.api.customer.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.customer.entities.CustomerEntity;
import com.api.customer.exceptions.ErrorResponse;
import com.api.customer.model.request.SearchRequest;
import com.api.customer.model.request.UpdateRequest;
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

    /**
     * Update client status.
     * 
     * @param customerId ID of the customer to update batch.
     * @param status     New customer's status.
     * @return ResponseEntity contains the response body.
     */
    @PatchMapping(value = "/customer/{customerId}/{status}")
    public ResponseEntity<?> updateCustomerStatus(@Valid @PathVariable int customerId,
            @Valid @PathVariable String status) {
        return ResponseEntity.ok(customerService.updateCustomersStatus(customerId, status));
    }

    @PostMapping(value = "/customer/temporary")
    public ResponseEntity<?> updateProfile(@Valid @RequestBody UpdateRequest updateRequest) {
        return ResponseEntity.ok(customerService.updateRequestProfile(updateRequest));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, List<ErrorResponse>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ErrorResponse> errors = new ArrayList<ErrorResponse>();
        Map<String, List<ErrorResponse>> errorResponse = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            ErrorResponse errorObj = new ErrorResponse(fieldName, errorMessage);
            errors.add(errorObj);
        });
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}
