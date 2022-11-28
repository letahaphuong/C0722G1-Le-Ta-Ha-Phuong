package com.example.rom_for_rent.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity
@Table(name = "room_for_rent")
public class RoomForRent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    private String customerName;

    private String phoneNumber;

    @Column(columnDefinition = "date")
    private String startDate;

    @Column(columnDefinition = "text")
    private String note;

    @ManyToOne
    @JoinColumn(name = "payment_id",nullable = false,referencedColumnName = "payment_id")
    @JsonManagedReference
    private Payment payment;

    public RoomForRent() {
    }

    public RoomForRent(Long roomId, String customerName, String phoneNumber, String startDate, String note, Payment payment) {
        this.roomId = roomId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.note = note;
        this.payment = payment;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
