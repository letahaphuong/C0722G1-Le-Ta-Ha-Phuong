package com.example.case_study.model.contract;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attach_facility")
public class AttachFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetails;
}
