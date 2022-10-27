package service.impl;

import model.AccountsSaveBank;
import service.IAccountsSaveBankService;
import util.CheckUtils;
import util.UserException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountsSaveService implements IAccountsSaveBankService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<AccountsSaveBank> saveBankList = new ArrayList<>();

    public AccountsSaveBank info() {
        int id;
        while (true) {
            if (!saveBankList.isEmpty()) {
                id = saveBankList.get(saveBankList.size() - 1).getIdAcc() + 1;
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
        double moneyAcc;
        while (true) {
            try {
                System.out.println("Số tiền gửi tiết kiện: ");
                moneyAcc = Double.parseDouble(scanner.nextLine());
                if (moneyAcc>=0){
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Sai định dạng,Nhập lại!");
            }

        }
        String dateDeposit;
        while (true) {
            try {
                System.out.println("Nhập ngày gửi tiết kiệm: ");
                dateDeposit = scanner.nextLine();
                CheckUtils.checkDate(dateDeposit);
                break;
            } catch (UserException e) {
                e.printStackTrace();
            }

        }
        String interestRate;
        while (true) {
            System.out.println("Nhập Lãi Suất: ");
            interestRate = scanner.nextLine();
            break;
        }
        String tenor;
        while (true) {
            System.out.println("Nhập kì hạn: ");
            tenor = scanner.nextLine();
            break;
        }
        return new AccountsSaveBank(id, codeAcc, name, dateCre, moneyAcc,
                dateDeposit, interestRate, tenor);
    }

    @Override
    public void addSave() throws IOException {
        saveBankList = readFile();
        AccountsSaveBank accountsSaveBank = this.info();
        saveBankList.add(accountsSaveBank);
        System.out.println("Thêm mới thành công!");
        writeFile(saveBankList);
    }

    @Override
    public void removeSave() throws IOException {
        saveBankList = readFile();
        System.out.println("Nhập Mã khách hàng cần xoá: ");
        String codeAcc=scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < saveBankList.size(); i++) {
            if (saveBankList.get(i).getCodeAcc().equals(codeAcc)) {
                System.out.println("Bạn có chắc chắn muốn xoá: " +
                        "\n y : Để Xoá" +
                        "\n n : Để trở lại");
                String chocie = scanner.nextLine();
                if (chocie.equals("y")) {
                    saveBankList.remove(i);
                    System.out.println("Xoá thành công!");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy ID");
        }
        writeFile(saveBankList);
    }

    @Override
    public void displaySave() throws IOException {
        saveBankList = readFile();
        for (AccountsSaveBank accountsSaveBank : saveBankList) {
            System.out.println(accountsSaveBank);
        }
    }

    @Override
    public void findSave() throws IOException {
        saveBankList=readFile();
        System.out.println("Nhập Mã Tài Khoản: ");
        String codeAcc=scanner.nextLine();
        for (int i = 0; i < saveBankList.size(); i++) {
            if (saveBankList.get(i).getCodeAcc().equals(codeAcc)){
                System.out.println(saveBankList.get(i));
            }
        }

    }

    public List<AccountsSaveBank> readFile() throws IOException {
        BufferedReader bufferedReader = null;
        List<AccountsSaveBank> accountsSaveBankList = new ArrayList<>();
        try {
            File file = new File("src\\data\\saveBank.csv");
            FileReader fileReader = new FileReader(file);
            if (!file.exists()) {
                System.err.println("File Not Found!");
            }
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            AccountsSaveBank accountsSaveBank;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                accountsSaveBank = new AccountsSaveBank();
                accountsSaveBank.setIdAcc(Integer.parseInt(info[0]));
                accountsSaveBank.setCodeAcc(info[1]);
                accountsSaveBank.setNameAcc(info[2]);
                accountsSaveBank.setDateCre(info[3]);
                accountsSaveBank.setMoneyAcc(Double.parseDouble(info[4]));
                accountsSaveBank.setDateDeposit(info[5]);
                accountsSaveBank.setInterestRate(info[6]);
                accountsSaveBank.setTenor(info[7]);
                accountsSaveBankList.add(accountsSaveBank);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }

        return accountsSaveBankList;
    }

    public void writeFile(List<AccountsSaveBank> accountsSaveBankList) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src\\data\\saveBank.csv");
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (AccountsSaveBank accountsSaveBank : accountsSaveBankList) {
                bufferedWriter.write(accountsSaveBank.getInfo());
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
