package com.example.demo.service;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(Long id) throws ResourceNotFoundException {
        return customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteCustomer(Long theId) {
        customerRepository.deleteById(theId);
    }

    @Override
    public List<Customer> findCustomersByFirstName(String name) {
        return customerRepository.findCustomersByFirstNameCustomer(name);
    }


}