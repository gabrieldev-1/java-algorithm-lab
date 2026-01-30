package data_structure.linked_lists;

/**
 * Iterative implementation of a Singly Linked List.
 * * * Key Operations:
 * - add(data): Appends to the end of the list. Time Complexity: O(n).
 * - remove(data): Removes the first occurrence of data. Time Complexity: O(n).
 * * * Note: This implementation maintains a 'size' variable to provide O(1) 
 * access to the list's length, though searching remains linear.
 */
public class SingleLinkedList {
    private Node head;
    private int size;

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;

    }

    public Boolean remove(int data) {
        if (head == null) return false;

        if(head.data == data) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while(current.next != null && current.next.data != data) {
            current = current.next;

        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        } 

        return false;


    }
}