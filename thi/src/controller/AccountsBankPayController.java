package controller;

import service.IAccountsPayBankService;
import service.impl.AccountsPayService;

import java.io.IOException;
import java.util.Scanner;

public class AccountsBankPayController {
    private static Scanner scanner = new Scanner(System.in);
    private static IAccountsPayBankService iAccountsPayBankService = new AccountsPayService();

    public void menuPayBank() throws IOException {
        while (true) {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG");
            System.out.println("Chọn chức năng theo số ( dể tiếp tục: ");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xoá");
            System.out.println("3. Xem danh sách các tài khoản ngân hàng");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.println("0. Trở lại chương trình.");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    iAccountsPayBankService.addPay();
                    break;
                case "2":
                    iAccountsPayBankService.removePay();
                    break;
                case "3":
                    iAccountsPayBankService.displayPay();
                    break;
                case "4":
                    iAccountsPayBankService.findPay();
                    break;
                case "5":
                    System.exit(0);
                case "0":
                    return;
                default:
                    System.out.println("Bạn nhập sai định dạng vui lòng nhập lại!");
            }
        }
    }
}
