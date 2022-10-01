package case_study_module2.controller;

import java.util.Scanner;

public class BookingController {
    private static Scanner scanner=new Scanner(System.in);
    public static void menuBooking(){
        while (true){
            System.out.println("Welcome to Booking Management");
            System.out.println("Please select option: ");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            System.out.println("7. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    return;
                case 7:
                    System.exit(0);

            }
        }

    }
}
