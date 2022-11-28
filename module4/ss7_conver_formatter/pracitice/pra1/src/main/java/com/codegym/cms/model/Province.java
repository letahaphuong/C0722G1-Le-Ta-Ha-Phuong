package com.codegym.cms.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "province")
public class Province {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "province_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "province",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Customer> customers;

    public Province() {
    }

    public Province(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}