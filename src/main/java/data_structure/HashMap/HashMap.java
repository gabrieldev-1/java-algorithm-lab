package data_structure.HashMap;

import java.util.NoSuchElementException;

public class HashMap<K, V> {

    private static final double LOAD_FACTOR = 0.75;
    private static final int DEFAULT_CAPACITY = 16;

    private Node<K, V>[] table;
    private int size;
    private int capacity;
    private int threshold;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public HashMap() {
        this.capacity = DEFAULT_CAPACITY;
        this.table = new Node[capacity];
        this.threshold = (int) (capacity * LOAD_FACTOR);        
        this.size = 0;
    }

    private int index(K key, int capacity) {
        int hash = key.hashCode() & 0x7fffffff;
        return hash % capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Node<K, V>[] newTable = new Node[newCapacity];

        for (int i = 0; i < capacity; i++) {
            Node<K, V> current = table[i];

            while (current != null) {
                Node<K, V> next = current.next;

                int newIndex = index(current.key, newCapacity);

                current.next = newTable[newIndex];
                newTable[newIndex] = current;

                current = next;
            }
        }

        table = newTable;
        capacity = newCapacity;
        threshold = (int) (capacity * LOAD_FACTOR);
    }
    
    public V get(K key) {
        int index = index(key, capacity);
        Node<K, V> element = table[index];
        
        while (element != null) {
            if(element.key.equals(key)) {
                return element.value;
            }
            element = element.next;
        }

        return null;
        
    }

    public void put(K key, V value) {
        if(size >= threshold) {
            resize();
        }

        int index = index(key, capacity); 
        Node<K, V> current = table[index];
        Node<K, V> head = current;

        while(current != null) {
            if(current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node<K, V> newNode = new Node<K, V>(key, value);
        newNode.next = head;
        table[index] = newNode;
        size++;

    }

    public void remove(K key) {
        int index = index(key, capacity);
        Node<K, V> current = table[index];
        Node<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }

        throw new NoSuchElementException();
    }
}
