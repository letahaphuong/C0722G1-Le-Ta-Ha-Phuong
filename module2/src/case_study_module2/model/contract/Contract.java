package case_study_module2.model.contract;

import case_study_module2.model.booking.Booking;

import java.time.LocalDate;

public class Contract extends Booking {
    private int contractNumber;
    private String idBooking = getIdBooking();
    private int deposit;
    private int totalPayment;
    private String idCustomer = getIdCustomer();

    public Contract(String idCustomer, String typeGuest, String address, String idBooking, LocalDate beginDay, LocalDate endDay, String idCustomer1, String serviceName, String serviceType, int contractNumber, String idBooking1, int deposit, int totalPayment, String idCustomer2) {
        super(idCustomer, typeGuest, address, idBooking, beginDay, endDay, idCustomer1, serviceName, serviceType);
        this.contractNumber = contractNumber;
        this.idBooking = idBooking1;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.idCustomer = idCustomer2;
    }

    public Contract(String name, LocalDate birth, String gender, String idCard, String phoneNumber, String email, String idCustomer, String typeGuest, String address, String idBooking, LocalDate beginDay, LocalDate endDay, String idCustomer1, String serviceName, String serviceType, int contractNumber, String idBooking1, int deposit, int totalPayment, String idCustomer2) {
        super(name, birth, gender, idCard, phoneNumber, email, idCustomer, typeGuest, address, idBooking, beginDay, endDay, idCustomer1, serviceName, serviceType);
        this.contractNumber = contractNumber;
        this.idBooking = idBooking1;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.idCustomer = idCustomer2;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    @Override
    public String getIdBooking() {
        return idBooking;
    }

    @Override
    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    @Override
    public String getIdCustomer() {
        return idCustomer;
    }

    @Override
    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber=" + contractNumber +
                ", idBooking='" + idBooking + '\'' +
                ", deposit=" + deposit +
                ", totalPayment=" + totalPayment +
                ", idCustomer='" + idCustomer + '\'' +
                '}';
    }
}
