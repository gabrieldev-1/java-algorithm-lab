package data_structure.linked_lists;

class DoublyNode extends Node {
    private DoublyNode prev;

    public DoublyNode(int data) {
        super(data);
    }

    public DoublyNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyNode prev) {
        this.prev = prev;
    }

    public DoublyNode getNextNode() {
        return (DoublyNode) this.getNext();
    }

    public void setNextNode(DoublyNode next) {
        this.setNext(next);
    }
}

public class DoublyLinkedList {

    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

     public DoublyNode getHead() {
        return head;
    }

    public void add(int data) {

        DoublyNode newNode = new DoublyNode(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        tail.setNextNode(newNode);
        newNode.setPrev(tail);
        tail = newNode;
        size++;
    }
}

