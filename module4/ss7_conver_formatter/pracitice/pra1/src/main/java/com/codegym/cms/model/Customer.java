package com.codegym.cms.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    private String firstName;

    private String lastName;


    @ManyToOne
    @JoinColumn(name = "province_id",nullable = false,referencedColumnName = "province_id")
    @JsonManagedReference
    private Province province;

    public Customer() {
    }

    public Customer(Long customerId, String firstName, String lastName, Province province) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.province = province;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}