package com.example.case_study.model.facility;

import com.example.case_study.model.contract.Contract;
import org.omg.CORBA.LongHolder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "facility")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int are;

    private double cost;

    private int maxPeoPel;

    @ManyToOne
    @JoinColumn(name = "facility_type_id", referencedColumnName = "id")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    private RentType rentType;

    @OneToMany(mappedBy = "facility")
    private Set<Contract> contracts;

}


