package ss11_stack_queue.practice.queue_linkedlist.controller;

import ss11_stack_queue.practice.queue_linkedlist.model.MyQueue;

public class MyQueueController {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(9);
        queue.enqueue(8);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(7);

        System.out.println("Dequeued item is: " + queue.dequeue().key);
    }
}
