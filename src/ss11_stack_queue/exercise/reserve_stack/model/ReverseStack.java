package ss11_stack_queue.exercise.reserve_stack.model;


import java.util.Stack;

public class ReverseStack {
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
        Stack<Integer> stack = new Stack<>();
        for (Integer arrays : array) {
            stack.push(arrays);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }
}



