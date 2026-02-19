package data_structure.HashMap;

import java.util.Currency;

class BucketNode {
    private String key;
    private int value;
    private BucketNode next;

    public BucketNode(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    // GETTERS:

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
    
    public BucketNode getNext() {
        return next;
    }
    
    // SETTERS:

    public void setKey(String newKey) {
        key = newKey;
    }

    public void setValue(int newValue) {
        value = newValue;
    }

    public void setNext(BucketNode newNext) {
        next = newNext;
    }
}

public class Bucket {
    private BucketNode head;
    private int size;

    public Bucket() {
        this.head = null;
        this.size = 0;
    }

    public BucketNode getHead() {
        return head;
    }

    public void setHead(BucketNode newHead) {
        head = newHead;
    }

    public Boolean isEmpty() {
        return size == 0;

    }

    public void add(String key, int value) {
        BucketNode newNode = new BucketNode(key, value);
        
        if(isEmpty()) {
            head = newNode;
            size++;
            return;
        }

        newNode.setNext(head);
        head = newNode;
        size++;

    }

    public boolean remove(String key) {
        if(isEmpty()) {
            System.out.println("Queue is empty.");
            return false;
        }

        if(key.equals(head.getKey())) {
            head = head.getNext();
            size--;
            return true;
        }

        BucketNode current = head;        
        while(current.getNext() != null && current.getNext().getKey() != key) {
            current = current.getNext();
        }

        if(current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            size--;
            return true;
        }

        System.out.println("The key not exists.");
        return false;
    }

    public boolean replace(String key, int newValue) {
        BucketNode current = head;

        while(current != null) {
            if(current.getKey().equals(key)) {
                current.setValue(newValue);
                return true;
            }

            current = current.getNext();
        }

        return false;
    }


    public void print() {
        BucketNode current = head;
        while(current != null) {
            System.out.println("key: " + current.getKey() + " " + "value: " + current.getValue());
            current = current.getNext();
        }
    }


    public static void main(String[] args) {
        Bucket list = new Bucket();

        list.add("Gabriel", 7);
        list.add("Lucas", 3);
        list.add("Pablo", 9);
  
        list.print();
        list.remove("Gabriel");

        System.out.println("New list: ");
        list.print();
    }

}
