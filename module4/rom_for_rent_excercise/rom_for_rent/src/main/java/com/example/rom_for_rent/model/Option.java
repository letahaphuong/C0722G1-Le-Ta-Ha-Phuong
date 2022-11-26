package com.example.rom_for_rent.model;
import javax.persistence.*;

@Entity
@Table(name = "mcq_Options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "option_id")
    private int optionId;

    private String option;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Question questionId;



}

//package com.example.rom_for_rent.model;
//
//import javax.persistence.*;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Table(name = "rom_for_rent")
//public class RoomForRent {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "roomId")
//    private Long roomId;
//
//    @Column(name = "customer_name",columnDefinition = "nvarchar(50)")
//    private String customerName;
//
//    @Column(columnDefinition = "varchar(50)")
//    private String phoneNumber;
//
//    @Column(columnDefinition = "date")
//    private String startDate;
//
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "Answer",joinColumns = @JoinColumn(name = "room_id"),inverseJoinColumns = @JoinColumn(name = "id"))
//    private List<Payment> payments;
//
//    @OneToMany(mappedBy = "roomId",cascade = CascadeType.ALL)
//    private Set<Payment> payment;
//
//    public RoomForRent() {
//    }
//
//    public RoomForRent(Long roomId, String customerName, String phoneNumber, String startDate, List<Payment> payments, Set<Payment> payment) {
//        this.roomId = roomId;
//        this.customerName = customerName;
//        this.phoneNumber = phoneNumber;
//        this.startDate = startDate;
//        this.payments = payments;
//        this.payment = payment;
//    }
//
//    public Long getRoomId() {
//        return roomId;
//    }
//
//    public void setRoomId(Long roomId) {
//        this.roomId = roomId;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(String startDate) {
//        this.startDate = startDate;
//    }
//}
