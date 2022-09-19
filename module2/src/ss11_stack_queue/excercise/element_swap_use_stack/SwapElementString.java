package ss11_stack_queue.excercise.element_swap_use_stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SwapElementString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] array;
        Stack<String> beforeSwap = new Stack<>();
        Stack<String> afterSwap = new Stack<>();
        System.out.println("Nhập chuỗi cần đảo: ");
        String str = scanner.nextLine();
        array = str.split("");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            beforeSwap.push(array[i]);
        }
        System.out.println(beforeSwap.size());
        for (int i = 0; i < beforeSwap.size() + i; i++) {
            afterSwap.push(beforeSwap.pop());
        }
        System.out.println("Mảng sau khi đổi: " + afterSwap);


    }
}
