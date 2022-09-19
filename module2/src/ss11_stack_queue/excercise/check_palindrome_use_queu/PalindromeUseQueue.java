package ss11_stack_queue.excercise.check_palindrome_use_queu;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class PalindromeUseQueue {
    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";
        str = str.toUpperCase();
        String[] array;
        array = str.split("");
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
            queue.offer(array[i]);
        }
        boolean isCheck = true;
        for (int i = 0; i < stack.size(); i++) {
            if (queue.poll().equals(stack.pop())) {
                isCheck = true;
                break;
            }
            isCheck = false;
        }
        if (isCheck){
            System.out.println("Ok");
        }else {
            System.out.println("NO");
        }
    }
}
