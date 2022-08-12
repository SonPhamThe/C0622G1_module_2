package ss11_stack_queue.practice.stack_linkedlist.controller;

import ss11_stack_queue.practice.stack_linkedlist.model.MyStack;

public class MyStackController {
    private static void stackOfStrings() {
        MyStack<String> stack = new MyStack<>();
        stack.push("Five");
        stack.push("Four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");

        System.out.println("1.1 Size of stack after push operations: " + stack.size());
        System.out.println("1.2 Pop elements from stack: " + stack.pop());

        while (!stack.isEmpty()) {
            System.out.printf("%s", stack.pop());
        }
        System.out.println("\n1.3. Size of stack after pop operations: " + stack.size());
    }

    private static void stackOfInteger() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println("2.1 Size of stack after push operation: " + stack.size());
        System.out.println("2.2 Pop elements from stack: ");

        while (!stack.isEmpty()) {
            System.out.printf("%d", stack.pop());
        }
        System.out.println("\n2.3. Size of stack after pop operation: " + stack.size());
    }

    public static void main(String[] args) {
        System.out.println("1. Stack of Integers");
        stackOfInteger();
        System.out.println("\n2. Stack of String");
        stackOfStrings();
    }
}
