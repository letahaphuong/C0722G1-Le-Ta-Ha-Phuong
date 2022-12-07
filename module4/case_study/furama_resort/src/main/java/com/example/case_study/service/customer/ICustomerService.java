package com.example.case_study.service.customer;

import com.example.case_study.dto.customer.CustomerView;
import com.example.case_study.model.customer.Customer;
import com.example.case_study.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<CustomerView> searchView(String name,Pageable pageable);
}
