package service;

import java.io.IOException;

public interface IAccountsPayBankService {

    void addPay() throws IOException;

    void removePay() throws IOException;

    void displayPay() throws IOException;

    void findPay() throws IOException;
}
