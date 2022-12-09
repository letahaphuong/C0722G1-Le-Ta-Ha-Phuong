package com.example.case_study.model.employee;

import com.example.case_study.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String dateOfBirth;

    private String idCard;

    private double salary;

    private String phoneNumber;

    private String email;

    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id",referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    private Division division;

    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    private Set<Contract> contracts;

}
