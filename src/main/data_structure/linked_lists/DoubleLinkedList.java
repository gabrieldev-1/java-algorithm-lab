package data_structure.linked_lists;

public class DoubleLinkedList {
    private Node head;
    private int size;

    private static class Node {
        int data;
        Node next;
        Node previous;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if(head == null && size == 0) {
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.previous = current;
        size++;

    }

    public Boolean remove(int data) {
        if (head == null) return false;

        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
            size--;
            return true;
        }

        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current != null) {
            if (current.next != null) {
                current.next.previous = current.previous;
            }
            if (current.previous != null) {
                current.previous.next = current.next;
            }
            size--;
            return true;
        }

        System.out.println("Element not found.");
        return false;
    }
}
