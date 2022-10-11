package controller;

import service.IStudentService;
import service.impl.StudentService;

import java.io.IOException;
import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    private static IStudentService iStudentService = new StudentService();

    public void menuStudent() throws IOException {
        while (true) {
            System.out.println("WELCOME TO MANAGEMENT STUDENT!");
            System.out.println("Please Select Option");
            System.out.println("1. Add New Student!");
            System.out.println("2. Remove Student!");
            System.out.println("3. Display Student!");
            System.out.println("4. Back to Menu!");
            System.out.println("0. Exit Programming!");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    iStudentService.addStudent();
                    break;
                case "2":
                    iStudentService.removeStudent();
                    break;
                case "3":
                    iStudentService.displayStudent();
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Format Error,Pls Try Again!");
            }
        }
    }
}
