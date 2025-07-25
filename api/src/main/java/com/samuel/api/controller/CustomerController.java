package com.samuel.api.controller;

import com.samuel.api.entity.Customer;
import com.samuel.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        System.out.println("Dados recebidos do cliente: " + customer);
        return customerService.createCustomer(customer);
    }

    @GetMapping("/customers")
    private List<Customer> getAllCustomer(){
        return  customerService.getAllCustomer();
    }

}
