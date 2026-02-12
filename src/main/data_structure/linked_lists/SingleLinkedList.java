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

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node newHead) {
        this.head = newHead;
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        size++;

    }

    public Boolean addNext(int data, int previous) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return true;
        }

        Node current = head;
        while(current != null && current.getData() != previous) {
            current = current.getNext();
        }

        if(current == null) {
            System.out.println("This position does not exist.");
            return false;

        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        return true;
    }

    public Boolean removeFirst() {
        if (head == null) return false;

        head = head.getNext();
        return true;
    }

    public Boolean removeLast() {
        if (head == null) return false;
        
        if(head.getNext() == null) {
            head = null;
            return true;
        }

        Node current = head;
        while(current.getNext().getNext() != null) {
            current = current.getNext();     
        }

        current.setNext(null);
        return true;
    }

    public Boolean removeNode(int data) {
        if (head == null) return false;

        if(head.getData() == data) {
            head = head.getNext();
            size--;
            return true;
        }

        Node current = head;
        while(current.getNext() != null && current.getNext().getData() != data) {
            current = current.getNext();

        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            size--;
            return true;
        } 

        return false;
    }

    public Boolean print() {
        if(head == null) {
            System.out.println("The list is empty");
            return false;
        }

        Node current = head;
        while(current != null) {
            System.out.println(current.getData() + " -> ");
            current = current.getNext();
        }
        return true;
    }
}
