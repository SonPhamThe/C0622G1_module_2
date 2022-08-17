package ss11_stack_queue.exercise.demical_binary.controller;

import ss11_stack_queue.exercise.demical_binary.model.DecimalToBinary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinaryController {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.println("Enter a decimal number");
        int number = Integer.parseInt(scan.nextLine());

        DecimalToBinary.ChangeDecimalToBinary(number);
    }
}
