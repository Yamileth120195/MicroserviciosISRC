package com.practica.customer_service.service;

import com.practica.customer_service.dto.CustomerRequest;
import com.practica.customer_service.dto.CustomerResponse;
import com.practica.customer_service.entity.CustomerEntity;
import com.practica.customer_service.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService{

    private final ICustomerRepository repository;
    private final CustomerMapper mapper;

    //Crear un cliente
    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {
        CustomerEntity customer = mapper.toCustomer(request);
        repository.save(customer);
        return mapper.toCustomerResponse(customer);
    }

    //Buscar un cliente por id
    @Override
    public CustomerResponse findCustomerByID(String id) {
        return repository.findById(id)
                .map(customer -> mapper.toCustomerResponse(customer))
                .orElseThrow(()->  new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro el cliente con el ID "+id));
    }

    //Buscar clientes
    @Override
    public List<CustomerResponse> findCustomers() {
        List<CustomerEntity> list = repository.findAll();
        if(list.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontraron clientes");
        }

        return repository.findAll()
                .stream().map(customer -> mapper.toCustomerResponse(customer))
                .toList();
    }

    //Actualizar cliente por id
    @Override
    public CustomerResponse updateCustomerByID(String id, CustomerRequest request) {
        Optional<CustomerEntity> optional = repository.findById(id);
        if (optional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro cliente con el ID "+id);
        }
        CustomerEntity customer = optional.get();

        if(request.firstName() != null){
            customer.setFirstName(request.firstName());
        }
        if(request.lastName() != null){
            customer.setLastName(request.lastName());
        }
        if(request.phone() != null){
            customer.setPhone(request.phone());
        }
        if(request.email() != null){
            customer.setEmail(request.email());
        }
        if(request.address() != null){
            customer.setAddress(request.address());
        }
        if(request.city() != null){
            customer.setCity(request.city());
        }

        repository.save(customer);
        return mapper.toCustomerResponse(customer);
    }

    //Eliminar cliente por id
    @Override
    public String deleteCustomerByID(String id) {
        Optional<CustomerEntity> customerOptional = repository.findById(id);
        if(!customerOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encuentra el cliente con el ID "+id);
        }
        repository.deleteById(id);
        return "Se elimino el cliente con el ID "+id;
    }


}
