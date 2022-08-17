package ss11_stack_queue.exercise.palindrome_queue.controller;

import ss11_stack_queue.exercise.palindrome_queue.model.PalindromeQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeQueueController {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your String to check");
        String string = scan.nextLine();

        PalindromeQueue.checkPalindrome(string);
    }
}
