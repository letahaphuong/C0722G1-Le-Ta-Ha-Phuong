package ss4_class_object.excercise.quadraticEquation;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;//khai báo trường dữ liệu
    private double b;
    private double c;

    public QuadraticEquation() {//Khai báo thuộc tính.Constructor.

    }

    public QuadraticEquation(double a, double b, double c) {//Khởi tạo thuộc tính,định nghĩa các phương thức khởi tạo(Contrustor)
        this.a = a;
        this.b = b;
        this.c = c;
    }

//    public double getA() {
//        return a;
//    }
//
//    public double getB() {
//        return b;
//    }
//
//    public double getC() {
//        return c;
//    }

    public double getDiscriminant() {//Định nghĩa phương thức get... trả về delta
        return Math.pow(this.b, 2) - 4 * this.a * this.c;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = Integer.parseInt(sc.nextLine());
        System.out.print("Enter b: ");
        double b = Integer.parseInt(sc.nextLine());
        System.out.print("Enter c: ");
        double c = Integer.parseInt(sc.nextLine());
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant()>0){
            System.out.printf("Delta = %f : Phương trình có 2 nghiệm phân biệt!",quadraticEquation.getDiscriminant());
        }else if(quadraticEquation.getDiscriminant()==0){
            System.out.printf("Delta = %f : Phương trình có nghiệm kép!",quadraticEquation.getDiscriminant());
        }else {
            System.out.println("Phương trình vô nghiệm!");
        }
    }
}
