package com.practica.customer_service.repository;

import com.practica.customer_service.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends MongoRepository<CustomerEntity,String> {
}
