package com.practica.customer_service.dto;

public record CustomerRequest(
        String firstName,
        String lastName,
        String email,
        String phone,
        String address,
        String city
) {
}
