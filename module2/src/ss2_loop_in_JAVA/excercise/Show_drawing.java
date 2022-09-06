package ss2_loop_in_JAVA.excercise;

import java.util.Scanner;

public class Show_drawing {
    public static void main(String[] args) {
        int width, height;
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Drawing rectangle");
        System.out.println("2. Drawing right triangle(bottom-left+bottom-right)");
        System.out.println("3. Drawing right triangle(top-left + top-right )");
        System.out.println("4. Drawing isosceles triangle");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        choice = sc.nextInt();
        String text = "";
        switch (choice) {
            case 1:
                System.out.println("Enter width: ");
                width = sc.nextInt();
                System.out.println("Enter height: ");
                height = sc.nextInt();


                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                            text += "*";
                    }
                    text += "\n";
                }
                System.out.println(text);
                break;
            case 2:
                System.out.println("Enter height: ");
                height = sc.nextInt();
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j <= i; j++) {
                        if (i==0);
                    }
                    text += "\n";
                }
                System.out.println(text);

                for (int i = 0; i < height; i++) {
                    for (int j = height; j >0; j--) {
                        if (j == height || i == height-1) {
                            text += "* ";
                        } else {
                            text += " ";
                        }
                    }
                    text += "\n";
                }
                System.out.println(text);
                break;
            case 3:
                System.out.println("Enter height: ");
                height = sc.nextInt();
                for (int i = height; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {
                        if (i == height) {
                            text += "* ";
                        } else {
                            text += "* ";
                        }
                    }
                    text += "\n";
                }
                System.out.println(text);
                break;
            case 4:
                System.out.println("Enter height: ");
                height = sc.nextInt();
                for (int i = 1; i <= height; i++) {
                    for (int j = height; j > i; j--) {
                        System.out.println(" ");
                    }
                    for (int j = 1; j <= 2 * i - 1; j++) {
                        System.out.println("* ");
                    }
                    System.out.println();
                }

                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("No choice!");
        }
    }
}
