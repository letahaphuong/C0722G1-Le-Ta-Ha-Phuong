package ss15_exception.excercise.ex1;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Scanner scanner = new Scanner(System.in);
        double a, b, c;
        while (true) {
            try {
                System.out.println("Nhập cạnh a: ");
                a = Double.parseDouble(scanner.nextLine());
                triangle.check(a);
                break;
            } catch (IllegalTriangleException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        }
        while (true) {
            try {
                System.out.println("Nhập cạnh b: ");
                b = Double.parseDouble(scanner.nextLine());
                triangle.check(b);
                break;
            } catch (IllegalTriangleException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        }
        while (true) {
            try {
                System.out.println("Nhập cạnh c: ");
                c = Double.parseDouble(scanner.nextLine());
                triangle.check(c);
                break;
            } catch (IllegalTriangleException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        }

        try {
            triangle.check(a, b, c);
            System.out.println("là ba cạnh tam giác");
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }

    }


    public void check(double x, double y, double z) throws IllegalTriangleException {

        if (x + y <= z || x + z <= y || y + z <= x) {
            throw new IllegalTriangleException("tổng hai cạnh nhỏ hơn 1 cạnh,k phải là 3 cạnh tam giác");
        }

    }

    public void check(double x) throws IllegalTriangleException {
        if (x <= 0) {
            throw new IllegalTriangleException("nhập lại cạnh lớn hơn 0");
        }
    }
    public void check1(double x) throws NumberFormatException{
        System.out.println(" Nhập sai định dạng vui lòng nhập lại");
    }

}
