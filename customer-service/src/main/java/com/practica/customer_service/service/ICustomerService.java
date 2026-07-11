package com.practica.customer_service.service;

import com.practica.customer_service.dto.CustomerRequest;
import com.practica.customer_service.dto.CustomerResponse;

import java.util.List;

public interface ICustomerService{
    //Crear un cliente
    public CustomerResponse createCustomer(CustomerRequest request);

    //Buscar un cliente por id
    public CustomerResponse findCustomerByID(String id);

    //Buscar clientes
    public List<CustomerResponse> findCustomers();

    //Actualizar cliente por id
    public CustomerResponse updateCustomerByID(String id, CustomerRequest request);

    //Eliminar cliente por id
    public String deleteCustomerByID(String id);
}
