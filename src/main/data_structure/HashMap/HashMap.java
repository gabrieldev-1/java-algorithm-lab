package data_structure.HashMap;

public class HashMap {
    private int size;
    private Bucket[] buckets;

    public HashMap(int size) {
        this.size = size;
        this.buckets = new Bucket[size];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
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

    public void add(String key, int value) {
        int index = calcIndex(key);
        Bucket bucket = buckets[index];

        // If the data exists, it replaces it;
        if(!bucket.replace(key, value)) {
            bucket.add(key, value);
        }
    }

    public void remove(String key) {
        int index = calcIndex(key);
        Bucket bucket = buckets[index];

        boolean result = bucket.remove(key);
        if(!result) {
            throw new RuntimeException();
        }
    }
}
