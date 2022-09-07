package ss3_array_in_java.excercise.Array_and_method;

import java.util.Scanner;

public class Max_in_2_dimensional_arrays {
    public static void main(String[] args) {
        int [][] array =new int[5][5];
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter "+ array.length + "rows and"+ array[0].length+ "colums: ");
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column <array[row].length ; column++) {
                array[row][column]=Integer.parseInt(sc.nextLine());
            }
        }
        System.out.print("Arrays list: ");
    }
}
