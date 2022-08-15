package ss11_stack_queue.exercise.demical_binary.model;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
   private static final Scanner scan = new Scanner(System.in);
   private static final Stack<Integer> stack = new Stack<>();
    public static void ChangeDecimalToBinary(int number) {
        while (number != 0) {
            stack.push(number % 2);
            number /= 2;
        }

        System.out.println("Number binary after change");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}

