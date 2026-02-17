package data_structure.queues;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Queue {
    private Node head;
    private Node tail;
    private int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    s
    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }

        return head.data;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty.");

        }

        int result = head.data;
        head = head.next;
        size--;

        if(head == null) {
            tail = null;
        }

        return result;
    }
}
