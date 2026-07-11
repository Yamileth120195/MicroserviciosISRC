package com.practica.customer_service.dto;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String address,
        String city
) {
}
