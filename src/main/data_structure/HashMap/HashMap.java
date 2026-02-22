package data_structure.HashMap;

import java.util.NoSuchElementException;

public class HashMap<K, V> {
    private static double LOAD_FACTOR = 0.75;

    private int capacity;
    private int size;
    private Bucket<K, V>[] buckets;

    public HashMap() {
        this.capacity = 16;
        this.size = 0;
        this.buckets = new Bucket[capacity];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket<>();
        }
    }

    public int getSize() {
        return size;
    }

    private boolean resize() {
        if (size <= capacity * LOAD_FACTOR) return false;

        int newCapacity = capacity * 2;

        @SuppressWarnings("unchecked")
        Bucket<K, V>[] newBuckets = new Bucket[newCapacity];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket<>();
        }

        for(int i = 0; i < capacity; i++) {
            Bucket<K, V> oldBucket = buckets[i];
            BucketNode<K, V> current = oldBucket.getHead();
           
            while(current != null) {
                int hash = current.getKey().hashCode() & 0x7fffffff;
                int newIndex = hash % newCapacity;

                newBuckets[newIndex].add(current.getKey(), current.getValue());
                current = current.getNext();
            }
            
        }

        buckets = newBuckets;
        capacity = newCapacity;
        return true;
    }

    /**
     * Generates the hash using key. After this, calculates the index
     * of the array;
     * @param key
     * @return index;
     */
    private int calcIndex(K key) {
        int hash = key.hashCode() & 0x7fffffff;
        return hash % buckets.length;

    }

    public void put(K key, V value) {
        resize();

        int index = calcIndex(key);
        Bucket<K, V> bucket = buckets[index];

        boolean replaced = bucket.replace(key, value);
        
        if(!replaced) {
            bucket.add(key, value);
            size++;
        }
    }

    public void remove(K key) {
        int index = calcIndex(key);
        Bucket<K, V> bucket = buckets[index];

        boolean result = bucket.remove(key);
        if(!result) {
            throw new RuntimeException();
        }
        size--;
    }

    public BucketNode<K, V> get(K key) {
        int index = calcIndex(key);
        Bucket<K, V> bucket = buckets[index];

        return bucket.get(key);
    }
}
