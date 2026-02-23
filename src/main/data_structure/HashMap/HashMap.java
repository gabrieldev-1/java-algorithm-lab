package data_structure.HashMap;

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

    private void resize() {

    }
    
    public Node<K, V> get(K key) {

    }

    public void put(K key, V value) {

    }

    public void remove(K key) {

    }
}
