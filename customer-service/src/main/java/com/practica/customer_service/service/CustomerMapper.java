package com.practica.customer_service.service;

import com.practica.customer_service.dto.CustomerRequest;
import com.practica.customer_service.dto.CustomerResponse;
import com.practica.customer_service.entity.CustomerEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public CustomerResponse toCustomerResponse(CustomerEntity customer){
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getCity()
        );
    }

    public CustomerEntity toCustomer(CustomerRequest request){
        return CustomerEntity.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .address(request.address())
                .city(request.city())
                .build();
    }
}
