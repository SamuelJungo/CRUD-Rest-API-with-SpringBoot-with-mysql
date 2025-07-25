package com.samuel.api.controller;

import com.samuel.api.entity.Customer;
import com.samuel.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
       Customer customer = customerService.getCustomerById(id);
       if(customer == null)
           return ResponseEntity.notFound().build();
       return ResponseEntity.ok(customer);
    }


    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
       Customer isCustomerExist = customerService.getCustomerById(id);
       if(isCustomerExist == null)
           return ResponseEntity.notFound().build();
       customerService.deleteCustomer(id);
       return ResponseEntity.ok().build();
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Customer existingCustomer = customerService.getCustomerById(id);
        if(existingCustomer == null)
            return ResponseEntity.notFound().build();
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        Customer updateCustomer = customerService.updateCustomer(existingCustomer);
        return ResponseEntity.ok(updateCustomer);

    }
}
