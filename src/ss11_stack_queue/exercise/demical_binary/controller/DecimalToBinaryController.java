package ss11_stack_queue.exercise.demical_binary.controller;

import ss11_stack_queue.exercise.demical_binary.model.DecimalToBinary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinaryController {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int number;

        do {
            System.out.println("Enter a decimal number");
            number = Integer.parseInt(scan.nextLine());
            if (number < 0) {
                System.out.println("Number your input Invalid, please number > 0");
            }
        } while (number < 0);

        DecimalToBinary.ChangeDecimalToBinary(number);
    }
}
