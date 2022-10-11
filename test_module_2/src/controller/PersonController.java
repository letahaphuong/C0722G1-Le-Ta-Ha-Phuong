package controller;

import java.io.IOException;
import java.util.Scanner;

public class PersonController {
    private static Scanner sc = new Scanner(System.in);
    private static StudentController studentController = new StudentController();
    private static TeacherController teacherController = new TeacherController();

    public static void displayMainMenu() throws IOException {
        while (true) {
            System.out.println("WELCOME TO MANAGEMENT STUDENT AND TEACHER!");
            System.out.println("Please Select Option");
            System.out.println("1. Management Student!");
            System.out.println("2. Management Teacher!");
            System.out.println("0. Exit Programming!");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    studentController.menuStudent();
                    break;
                case "2":
                    teacherController.menuTeacher();
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Format Error,Pls Try Again!");
            }
        }
    }
}