package case_study_module2.model.customer;

import case_study_module2.model.person.Person;

import java.time.LocalDate;

public class Customer extends Person {
    private String idCustomer;
    private String typeGuest;
    private String Address;
    public Customer(){

    }

    public Customer(String idCustomer, String typeGuest, String address) {
        this.idCustomer = idCustomer;
        this.typeGuest = typeGuest;
        Address = address;
    }

    public Customer(String name, LocalDate birth, String gender, String idCard, String phoneNumber, String email, String idCustomer, String typeGuest, String address) {
        super(name, birth, gender, idCard, phoneNumber, email);
        this.idCustomer = idCustomer;
        this.typeGuest = typeGuest;
        Address = address;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getTypeGuest() {
        return typeGuest;
    }

    public void setTypeGuest(String typeGuest) {
        this.typeGuest = typeGuest;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer='" + idCustomer + '\'' +
                ", typeGuest='" + typeGuest + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
