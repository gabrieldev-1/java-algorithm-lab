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
        if(getSize() == 0) {
            throw new NoSuchElementException("The array is empty.");
        }

        if(capacity * LOAD_FACTOR != size) {
            return false;
        }

        @SuppressWarnings("unchecked")
        Bucket<K, V>[] newBuckets = new Bucket[capacity * 2];

        for(int i = 0; i < size; i++) {
            Bucket<K, V> oldBucket = buckets[i];
            Bucket<K, V> newBucket = newBuckets[i];

            BucketNode<K, V> current = oldBucket.getHead();
            while(current.getNext() != null) {
                // continue...
            }
            
        }

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
