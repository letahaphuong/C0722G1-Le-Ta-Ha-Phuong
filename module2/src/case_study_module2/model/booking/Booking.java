package case_study_module2.model.booking;

import case_study_module2.model.customer.Customer;
import case_study_module2.model.facility.Facility;

import java.time.LocalDate;

public class Booking extends Customer{
    private String idBooking;
    private LocalDate beginDay;
    private LocalDate endDay;
    private String idCustomer=getIdCustomer();
    private String serviceName;
    private String serviceType;

    public Booking(String idCustomer, String typeGuest, String address, String idBooking, LocalDate beginDay, LocalDate endDay, String idCustomer1, String serviceName, String serviceType) {
        super(idCustomer, typeGuest, address);
        this.idBooking = idBooking;
        this.beginDay = beginDay;
        this.endDay = endDay;
        this.idCustomer = idCustomer1;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public Booking(String name, LocalDate birth, String gender, String idCard, String phoneNumber, String email, String idCustomer, String typeGuest, String address, String idBooking, LocalDate beginDay, LocalDate endDay, String idCustomer1, String serviceName, String serviceType) {
        super(name, birth, gender, idCard, phoneNumber, email, idCustomer, typeGuest, address);
        this.idBooking = idBooking;
        this.beginDay = beginDay;
        this.endDay = endDay;
        this.idCustomer = idCustomer1;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDate getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(LocalDate beginDay) {
        this.beginDay = beginDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    @Override
    public String getIdCustomer() {
        return idCustomer;
    }

    @Override
    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", beginDay=" + beginDay +
                ", endDay=" + endDay +
                ", idCustomer='" + idCustomer + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
