package case_study_module2.controller;

import java.util.Scanner;

public class CustomerController {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuCustomer() {
        while (true){
            System.out.println("Welcome to Customer Management");
            System.out.println("Please select option: ");
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return menu");
            System.out.println("5. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(0);
            }
        }

    }
}
