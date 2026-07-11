package com.practica.customer_service.controller;

import com.practica.customer_service.dto.CustomerRequest;
import com.practica.customer_service.dto.CustomerResponse;
import com.practica.customer_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    //Crear un cliente
    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest request) throws URISyntaxException {
        return ResponseEntity.created(new URI("/createCustomer")).body(service.createCustomer(request));
    }

    //Buscar un cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id){
        return ResponseEntity.ok(service.findCustomerByID(id));
    }

    //Buscar clientes
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findCustomers(){
        return ResponseEntity.ok(service.findCustomers());
    }

    //Actualizar cliente por id
    @PatchMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateById(@PathVariable String id,@RequestBody CustomerRequest request){
        return ResponseEntity.ok(service.updateCustomerByID(id,request));
    }

    //Eliminar cliente por id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id){
        service.deleteCustomerByID(id);
        return ResponseEntity.noContent().build();
    }
}
