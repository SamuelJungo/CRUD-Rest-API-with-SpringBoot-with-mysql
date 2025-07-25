package com.samuel.api.service;

import com.samuel.api.entity.Customer;
import com.samuel.api.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    public final CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);

    }

    public List<Customer> getAllCustomer(){
       return customerRepository.findAll();
    }


    public Customer getCustomerById(Long id)
    {
        return customerRepository.findById(id).orElse(null);
    }

    public  void  deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public  Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
