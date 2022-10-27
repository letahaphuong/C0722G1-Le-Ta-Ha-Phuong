package service.impl;

import model.AccountsPayBank;
import model.AccountsSaveBank;
import service.IAccountsPayBankService;
import util.CheckUtils;
import util.UserException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountsPayService implements IAccountsPayBankService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<AccountsPayBank> payBankList=new ArrayList<>();

    public AccountsPayBank info() {
        int id;
        while (true) {
            if (!payBankList.isEmpty()) {
                id = payBankList.get(payBankList.size() - 1).getIdAcc() + 1;
            } else {
                id = 1;
            }
            break;
        }
        String codeAcc;
        while (true) {
            try {
                System.out.println("Nhập mã tài khoản: ");
                codeAcc = scanner.nextLine();
                CheckUtils.checkCodeAcc(codeAcc);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        }
        String name;
        while (true) {
            try {
                System.out.println("Nhập tên chủ tài khoản: ");
                name = scanner.nextLine();
                CheckUtils.checkName(name);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        }

        String dateCre;
        while (true) {
            try {
                System.out.println("Nhập tạo tài khoản: ");
                dateCre = scanner.nextLine();
                CheckUtils.checkDate(dateCre);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        }
        String numberCard;
        while (true) {
            try {
                System.out.println("Số tiền gửi tiết kiện: ");
                numberCard = scanner.nextLine();
                CheckUtils.checkNumberCard(numberCard);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        }

        double moneyInCard;
        while (true) {
            try {
                System.out.println("Nhập kì hạn: ");
                moneyInCard = Double.parseDouble(scanner.nextLine());
                if (moneyInCard>=0){
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Sai định dang,Nhập lại!");
            }

        }
        return new AccountsPayBank(id, codeAcc, name, dateCre, numberCard,
                moneyInCard);
    }

    @Override
    public void addPay() throws IOException {
    payBankList=readFile();
    AccountsPayBank accountsPayBank=this.info();
    payBankList.add(accountsPayBank);
        System.out.println("Thêm mới thành công!");
        writeFile(payBankList);
    }

    @Override
    public void removePay() throws IOException {

        payBankList = readFile();
        System.out.println("Nhập mã khách hàng cần xoá: ");
        String codeAcc=scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < payBankList.size(); i++) {
            if (payBankList.get(i).getCodeAcc().equals(codeAcc)) {
                System.out.println("Bạn có chắc chắn muốn xoá: " +
                        "\n y : Để Xoá" +
                        "\n n : Để trở lại");
                String chocie = scanner.nextLine();
                if (chocie.equals("y")) {
                    payBankList.remove(i);
                    System.out.println("Xoá thành công!");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy ID");
        }
        writeFile(payBankList);
    }

    @Override
    public void displayPay() throws IOException {
    payBankList=readFile();
    for (AccountsPayBank accountsPayBank:payBankList){
        System.out.println(accountsPayBank);
    }
    }

    @Override
    public void findPay() throws IOException {
        payBankList=readFile();
        System.out.println("Nhập Mã Tài Khoản: ");
        String codeAcc=scanner.nextLine();
        for (int i = 0; i < payBankList.size(); i++) {
            if (payBankList.get(i).getCodeAcc().equals(codeAcc)){
                System.out.println(payBankList.get(i));
            }
        }
    }

    public List<AccountsPayBank> readFile() throws IOException {
        BufferedReader bufferedReader = null;
        List<AccountsPayBank> accountsPayBankList = new ArrayList<>();
        try {
            File file = new File("src\\data\\payBank.csv");
            FileReader fileReader = new FileReader(file);
            if (!file.exists()) {
                System.err.println("File Not Found!");
            }
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            AccountsPayBank accountsPayBank;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                accountsPayBank = new AccountsPayBank();
                accountsPayBank.setIdAcc(Integer.parseInt(info[0]));
                accountsPayBank.setCodeAcc(info[1]);
                accountsPayBank.setNameAcc(info[2]);
                accountsPayBank.setDateCre(info[3]);
                accountsPayBank.setNumberCard(info[4]);
                accountsPayBank.setMoneyInAcc(Double.parseDouble(info[5]));
                accountsPayBankList.add(accountsPayBank);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }

        return accountsPayBankList;
    }

    public void writeFile(List<AccountsPayBank> accountsPayBankList) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src\\data\\payBank.csv");
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (AccountsPayBank accountsPayBank : accountsPayBankList) {
                bufferedWriter.write(accountsPayBank.getInfo());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }
}
