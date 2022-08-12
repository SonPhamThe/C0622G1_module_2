package ss11_stack_queue.practice.stack_linkedlist.model;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStack<E> {
    private final LinkedList<E> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }

    public void push(E element) {
        stack.addFirst(element);
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

}
