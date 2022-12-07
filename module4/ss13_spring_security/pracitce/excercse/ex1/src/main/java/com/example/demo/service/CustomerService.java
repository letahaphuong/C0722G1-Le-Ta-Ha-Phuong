package com.example.demo.service;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(Long theId) throws ResourceNotFoundException;

    void deleteCustomer(Long theId) throws ResourceNotFoundException;

    List<Customer> findCustomersByFirstName(String name);
}