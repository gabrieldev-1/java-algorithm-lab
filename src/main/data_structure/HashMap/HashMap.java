package data_structure.HashMap;

public class HashMap {
    private int capacity;
    private int size;
    private Bucket[] buckets;

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Bucket[capacity];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
    }

    public int getSize() {
        return size;
    }

    /**
     * Generates the hash using key. After this, calculates the index
     * of the array;
     * @param key
     * @return index;
     */
    private int calcIndex(String key) {
        int hash = key.hashCode() & 0x7fffffff;
        return hash % buckets.length;

    }

    public void put(String key, int value) {
        int index = calcIndex(key);
        Bucket bucket = buckets[index];

        boolean replaced = bucket.replace(key, value);
        
        if(!replaced) {
            bucket.add(key, value);
            size++;
        }
    }

    public void remove(String key) {
        int index = calcIndex(key);
        Bucket bucket = buckets[index];

        boolean result = bucket.remove(key);
        if(!result) {
            throw new RuntimeException();
        }
        size--;
    }

    public BucketNode get(String key) {
        int index = calcIndex(key);
        Bucket bucket = buckets[index];

        return bucket.get(key);
    }
}
