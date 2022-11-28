package com.example.rom_for_rent.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @Column(name = "payment_name")
    private String name;

    @OneToMany(mappedBy = "payment",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<RoomForRent> roomForRents;

    public Payment() {
    }

    public Payment(Long id, String name) {
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

    public Set<RoomForRent> getRoomForRents() {
        return roomForRents;
    }

    public void setRoomForRents(Set<RoomForRent> roomForRents) {
        this.roomForRents = roomForRents;
    }
}
