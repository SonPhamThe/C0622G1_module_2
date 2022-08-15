package ss11_stack_queue.practice.array_queue.model;

public class ArrayQueue {
    private final int capacity;
    private final int[] queueArr;
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public ArrayQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    public boolean isQueueEmpty() {
        boolean status = false;
        if(currentSize == 0) {
            status = true;
        }
        return false;
    }

    public void enqueue(int item) {
        if(isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: "+item);
        } else {
            tail++;
            if(tail==capacity-1) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element "+item+" is pushed to Queue !");
        }
    }

    public void dequeue(int item) {
        if(isQueueEmpty()) {
            System.out.println("Underflow, unable to delete element: "+item);
        } else {
            head++;
            if(head == capacity-1) {
                System.out.println("Pop operation done! removed: "+queueArr[head-1]);
                head = 0;
            } else {
                System.out.println("Pop operation done! removed; "+queueArr[head -1]);
            }
            currentSize--;
        }
    }

    private boolean isQueueFull() {
        boolean status = false;
        if(currentSize==capacity) {
            status = true;
        }
        return status;
    }
}
