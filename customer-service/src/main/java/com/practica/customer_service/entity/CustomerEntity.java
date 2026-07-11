package com.practica.customer_service.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
}
