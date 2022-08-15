package ss11_stack_queue.exercise.reserve_stack.controller;

import java.util.Arrays;
import java.util.Scanner;

import static ss11_stack_queue.exercise.reserve_stack.model.ReverseStack.reverseArray;
import static ss11_stack_queue.exercise.reserve_stack.model.ReverseStack.reverseString;

public class ReverseStackController {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size;

        do {
            System.out.println("Enter size of array");
            size = Integer.parseInt(scan.nextLine());
            if (size < 0) {
                System.out.println("Size invalid, size must be >0");
            }
        } while (size < 0);

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter element of array");
            array[i] = Integer.parseInt(scan.nextLine());
        }

        System.out.println("Array before reverse: ");
        System.out.println(Arrays.toString(array));

        reverseArray(array);

        System.out.println("Array after reverse: ");
        System.out.println(Arrays.toString(array));

        System.out.println("Enter your string want to reverse");
        String string = scan.nextLine();


        System.out.println("Your string after reverse");
        reverseString(string);
    }
}
