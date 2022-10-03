package case_study_module2.controller;

import case_study_module2.service.IEmployeeService;
import case_study_module2.service.impl.EmployeeService;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeController {
    private static Scanner scanner = new Scanner(System.in);
    private static IEmployeeService iEmployeeService = new EmployeeService();

    public static void menuEmployee() throws IOException {
        while (true) {
            System.out.println("Welcome to Employee Management ");
            System.out.println("Please select option: ");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            System.out.println("5. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    iEmployeeService.display();
                    break;
                case 2:
                    iEmployeeService.add();
                    break;
                case 3:
                    iEmployeeService.editByID();
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(0);
            }
        }
    }
}
