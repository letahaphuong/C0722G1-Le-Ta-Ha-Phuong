package com.example.case_study.dto.customer;

import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.customer.CustomerType;

import java.util.Set;

public interface CustomerView {
    Long getId();

    CustomerType getCustomerType();

    String getName();

    String getDateOfBirth();

    String getPhoneNumber();

    boolean isGender();

    String getAddress();


}
