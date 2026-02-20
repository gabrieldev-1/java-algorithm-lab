package data_structure.HashMap;

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

    public boolean add(String key, int value) {
        BucketNode newNode = new BucketNode(key, value);
        
        if(isEmpty()) {
            head = newNode;
            size++;
            return true;
        }

        newNode.setNext(head);
        head = newNode;
        size++;

        return true;
    }

    public boolean remove(String key) {
        if(isEmpty()) {
            return false;
        }

        if(key.equals(head.getKey())) {
            head = head.getNext();
            size--;
            return true;
        }

        BucketNode current = head;        
        while(current.getNext() != null && !current.getNext().getKey().equals(key)) {
            current = current.getNext();
        }

        if(current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            size--;
            return true;
        }

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

    public BucketNode get(String key) {
        if(isEmpty()) {
            return null;
        }

        BucketNode current = head;
        while (current != null) {
            if(current.getKey().equals(key)) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }
}
