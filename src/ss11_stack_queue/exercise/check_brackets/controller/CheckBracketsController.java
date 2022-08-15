package ss11_stack_queue.exercise.check_brackets.controller;

import ss11_stack_queue.exercise.check_brackets.model.CheckBrackets;

import java.util.Scanner;

public class CheckBracketsController {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter string to check");
        String strings = scan.nextLine();


        System.out.println(CheckBrackets.checkBracket(strings) ? "Well" : "No");
    }
}
