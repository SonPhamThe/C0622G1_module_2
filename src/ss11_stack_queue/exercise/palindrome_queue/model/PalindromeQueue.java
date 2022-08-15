package ss11_stack_queue.exercise.palindrome_queue.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeQueue {
    private static final Stack<String> stack = new Stack<>();
    private static final Queue<String> queue = new LinkedList<>();

    public static void checkPalindrome(String string){
        int i, j;
        string = string.replaceAll("\\s", "");
        int halfLength = string.length() / 2;


        for (i = halfLength - 1; i >= 0; i--) {
            stack.push(String.valueOf(string.charAt(i)));
        }

        for (j = halfLength + 1; j < string.length(); j++) {
            queue.add(String.valueOf(string.charAt(j)));
        }

        if (stack.equals(queue)) {
            System.out.println("Input is a palindrome");
        } else {
            System.out.println("Input isn't a palindrome");
        }

    }
}
