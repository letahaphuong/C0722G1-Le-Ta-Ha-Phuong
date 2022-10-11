package controller;

import service.IStudentService;
import service.ITeacherService;
import service.impl.TeacherService;

import java.io.IOException;
import java.util.Scanner;

public class TeacherController {
    private Scanner scanner = new Scanner(System.in);
    private static ITeacherService iTeacherService = new TeacherService();

    public void menuTeacher() throws IOException {
        while (true) {
            System.out.println("WELCOME TO MANAGEMENT TEACHER!");
            System.out.println("Please Select Option");
            System.out.println("1. Add New Teacher!");
            System.out.println("2. Remove Teacher!");
            System.out.println("3. Display Teacher!");
            System.out.println("4. Back to Menu!");
            System.out.println("0. Exit Programming!");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    iTeacherService.addStudent();
                    break;
                case "2":
                    iTeacherService.removeStudent();
                    break;
                case "3":
                    iTeacherService.displayStudent();
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Format Error,Pls Try Again!");
            }
        }
    }
}
