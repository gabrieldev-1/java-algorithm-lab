package data_structure.HashMap;

public class HashMap<K, V> {
    private int capacity;
    private int size;
    private Bucket<K, V>[] buckets;

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Bucket[capacity];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket<>();
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
