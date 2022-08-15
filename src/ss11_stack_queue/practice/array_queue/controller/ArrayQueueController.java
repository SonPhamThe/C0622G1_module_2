package ss11_stack_queue.practice.array_queue.controller;

import ss11_stack_queue.practice.array_queue.model.ArrayQueue;
import ss11_stack_queue.practice.queue_linkedlist.model.MyQueue;

import java.util.Arrays;

public class ArrayQueueController {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(4);
        arrayQueue.enqueue(4);
        arrayQueue.enqueue(6);
        arrayQueue.enqueue(8);
        arrayQueue.dequeue(6);
        arrayQueue.dequeue(4);
    }
}
