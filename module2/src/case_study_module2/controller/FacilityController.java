package case_study_module2.controller;

import java.util.Scanner;

public class FacilityController {
    private static Scanner scanner=new Scanner(System.in);
    public static void menuFacility(){
        while (true){
            System.out.println("Welcome to Facility Management");
            System.out.println("Please select option: ");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            System.out.println("5. Exit");
            int choice =Integer.parseInt(scanner.nextLine());
            switch (choice){
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
