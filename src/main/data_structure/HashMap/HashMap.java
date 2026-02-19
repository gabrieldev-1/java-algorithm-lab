package data_structure.HashMap;

public class HashMap {
    private int size;
    private Bucket[] buckets;

    public HashMap(int size) {
        this.size = size;
        this.buckets = new Bucket[size];

        for(Bucket bucket : buckets) {
            bucket = new Bucket();
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

        if(!bucket.replace(key, value)) {
            bucket.add(key, value);
        }
    }

    public void remove(String key) {
        int index = calcIndex(key);
    }
}
