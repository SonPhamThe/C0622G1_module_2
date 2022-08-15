package ss11_stack_queue.practice.stack_array.controller;

import ss11_stack_queue.practice.stack_array.model.StackArray;

public class StackArrayController {
    public static void main(String[] args) throws Exception {
        StackArray stackArray = new StackArray(5);

        stackArray.push(4);
        stackArray.push(5);
        stackArray.push(6);
        stackArray.push(7);
        stackArray.push(8);

        System.out.println("1. Size of stack after push operations: \" + stack.size()");
        System.out.println("2. Pop elements from stack :");


        while (!stackArray.isEmpty()) {
            System.out.printf(" %d", stackArray.pop());
        }

        System.out.println("\n3. Size of stack after pop operations : " + stackArray.size());
    }
}
