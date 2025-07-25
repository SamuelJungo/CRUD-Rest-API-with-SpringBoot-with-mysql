package com.samuel.api.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;


}
