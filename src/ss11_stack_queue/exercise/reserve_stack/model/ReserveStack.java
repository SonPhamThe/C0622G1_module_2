package ss11_stack_queue.exercise.reserve_stack.model;

import java.util.LinkedList;

public class ReserveStack<E> {
    private final LinkedList<E> stack;

    public ReserveStack() {
        stack = new LinkedList<>();
    }
    public void push(E element) {
        stack.addFirst(element);
    }

}
