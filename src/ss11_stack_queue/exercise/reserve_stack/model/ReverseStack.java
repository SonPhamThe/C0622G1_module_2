package ss11_stack_queue.exercise.reserve_stack.model;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {
    private static final Scanner scan = new Scanner(System.in);

    public static void reverseString(String string) {
        Stack<String> stack = new Stack<>();
        String strings = "";
        int i;
        for (i = 0; i < string.length(); i++) {
            stack.push(String.valueOf(string.charAt(i)));
        }
        for (i = 0; i < string.length(); i++) {
            strings += stack.pop();
        }
        System.out.println(strings);
    }

    public static void reverseArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element of array");
            array[i] = Integer.parseInt(scan.nextLine());
        }

        System.out.println("Array before reverse: ");
        System.out.println(Arrays.toString(array));

        Stack<Integer> stack = new Stack<>();

        for (Integer arrays : array) {
            stack.push(arrays);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }

        System.out.println("Array after reverse: ");
        System.out.println(Arrays.toString(array));
    }
}



