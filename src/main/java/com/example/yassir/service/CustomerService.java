package com.example.yassir.service;

import com.example.yassir.model.Customer;
import com.example.yassir.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer createCustomer(String name) {
        return customerRepo.save(new Customer(null, name, new ArrayList<>()));
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }

    public Customer updateCustomer(Long id, String name) {
        return null ;
    }
}


