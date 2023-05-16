package com.api.customer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.api.customer.entities.CustomerEntity;

/**
 * 
 * @author thutrang
 */
public class Mapper {

    private List<CustomerEntity> customerEntities = new ArrayList<CustomerEntity>();

    public Mapper(List<CustomerEntity> customerEntities) {
        this.customerEntities = customerEntities;
    }

    public List<CustomerEntity> map() {
        return customerEntities.stream()
                .map(i -> new CustomerEntity(i.getCustomerId(), i.getFirstName(), i.getLastName(),
                        i.getIdCardNo(), i.getDob(), i.getPhone(), i.getEmail(), i.getUserName(),
                        i.getStatus(),
                        i.getAddress(),
                        i.getNationality(),
                        i.getOccupation(),
                        i.getMarried(), i.getPassportNo(),
                        i.getAgency()
                        ))
                .collect(Collectors.toList());
    }
}
