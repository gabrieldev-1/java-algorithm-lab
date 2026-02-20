package data_structure.HashMap;

class BucketNode<K, V> {
    private K key;
    private V value;
    private BucketNode<K, V> next;

    public BucketNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    // GETTERS:

    public K getKey() { return key; }

    public V getValue() { return value; }
    
    public BucketNode<K, V> getNext() { return next; }
    
    // SETTERS:

    public void setKey(K newKey) {
        key = newKey;
    }

    public void setValue(V newValue) {
        value = newValue;
    }

    public void setNext(BucketNode<K, V> newNext) {
        next = newNext;
    }
}

public class Bucket<K, V> {
    private BucketNode<K, V> head;
    private int size;

    public Bucket() {
        this.head = null;
        this.size = 0;
    }

    public BucketNode<K, V> getHead() {
        return head;
    }

    public void setHead(BucketNode<K, V> newHead) {
        head = newHead;
    }

    public Boolean isEmpty() {
        return size == 0;

    }

    public boolean add(K key, V value) {
        BucketNode<K, V> newNode = new BucketNode<>(key, value);
        
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

    public boolean remove(K key) {
        if(isEmpty()) {
            return false;
        }

        if(key.equals(head.getKey())) {
            head = head.getNext();
            size--;
            return true;
        }

        BucketNode<K, V> current = head;        
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

    public boolean replace(K key, V newValue) {
        BucketNode<K, V> current = head;

        while(current != null) {
            if(current.getKey().equals(key)) {
                current.setValue(newValue);
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    public BucketNode<K, V> get(K key) {
        if(isEmpty()) {
            return null;
        }

        BucketNode<K, V> current = head;
        while (current != null) {
            if(current.getKey().equals(key)) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }
}
