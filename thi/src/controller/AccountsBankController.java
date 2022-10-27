package controller;

import service.impl.AccountsPayService;

import java.io.IOException;
import java.util.Scanner;

public class AccountsBankController {
    private static Scanner scanner = new Scanner(System.in);
    private static AccountsBankSaveController accountsBankSaveController = new AccountsBankSaveController();
    private static AccountsBankPayController accountsBankPayController = new AccountsBankPayController();

    public static void displayMainMenu() throws IOException {
        while (true) {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG");
            System.out.println("Chọn chức năng theo số ( dể tiếp tục: " );
            System.out.println("1. Quản lý tài khoản tiết kiệm");
            System.out.println("2. Quản lý tài khoản thanh toán");
            System.out.println("0. Thoát");
            String choice=scanner.nextLine();
            switch (choice){
                case "1":
                    accountsBankSaveController.menuSaveBank();
                    break;
                case "2":
                    accountsBankPayController.menuPayBank();
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Bạn nhập sai định dạng vui lòng nhập lại!");
            }
        }
    }
}
