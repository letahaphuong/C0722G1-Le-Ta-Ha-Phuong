package ss11_stack_queue.excercise.check_bracket_in_stack;

import java.util.Scanner;
import java.util.Stack;

public class Check {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("nhập biểu thức: ");
        String str = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        String[] arrString = str.split("");
        boolean checkBracket = true;

        for (int i = 0; i < arrString.length; i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    checkBracket = false;
                    break;
                } else {
                    Character left = stack.pop();
                    if (!(left == '(')) {
                        checkBracket = false;
                        break;
                    }
                }
            }
            if (i == arrString.length - 1) {
                checkBracket = stack.isEmpty();
            }


        }
        if (checkBracket) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
