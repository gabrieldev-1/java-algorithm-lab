package data_structure.stacks;

import java.util.Arrays;

public class CircularQueue {
    private int[] list;
    private int front;
    private int rear;

    public CircularQueue(int size) {
        this.list = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % list.length == front;
    }

    public void push(int x) {
        if (isFull()) {
            throw new RuntimeException("Queue is full.");
        } 

        if(isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % list.length;
        list[rear] = x;

    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        int removedValue = list[front];
        list[front] = 0;

        if (front == rear) {
            front = -1;
            rear = -1;

        } else {
            front = (front + 1) % list.length;
        }
        
        return removedValue;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return list[front];
    }

    public void print() {
        if(isEmpty()) {
            System.out.print("The queue is empty.");
            return;
        }

        System.out.print("Queue: ");

        int i = front;
        while (true) {
            System.out.print(list[i] + " ");
            if (i == rear) break;
            i = (i + 1) % list.length;

        }
        
        System.out.println("\nArray state: " + Arrays.toString(list));
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(4);

        queue.push(3);
        queue.push(4);
        queue.push(1);
        queue.push(3);

        queue.pop();
        queue.pop();

        queue.push(1);
        queue.push(2);

        queue.pop();
        queue.pop();

        queue.print();
    }
}
