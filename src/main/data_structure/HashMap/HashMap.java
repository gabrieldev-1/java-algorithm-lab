package data_structure.HashMap;

import java.util.NoSuchElementException;

public class HashMap<K, V> {

    private static double LOAD_FACTOR = 0.75;
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

    private int index(K key) {
        int hash = key.hashCode() & 0x7fffffff;
        return hash % capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {

    }
    
    public Node<K, V> get(K key) {
        try {

            Node<K, V> element = table[index(key)];
            
            while (element.key != key) {
                element = element.next;
            }

            return element;
        
        } catch (NoSuchElementException err) {
            throw new NoSuchElementException("ERROR: The element not found. " + err.getMessage());

        }

    }

    public void put(K key, V value) {
        if(threshold >= size) {
            resize();
        }

        Node<K, V> current = table[index(key)];

        while (current != null) {
            current = current.next;
        }
        current = new Node<K, V>(key, value);

    }

    public void remove(K key) {
        try {
            

        } catch(NoSuchElementException err) {
            throw new NoSuchElementException("ERROR: The element not found. " + err.getMessage());
        }

    }

    public static void main(String[] args) {

    }
}
