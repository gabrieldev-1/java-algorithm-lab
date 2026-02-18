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

    public void add(String key, int value) {
        // generate hash. Removes the sign from negative numbers;
        int hash = key.hashCode() & 0x7fffffff;
        int index = hash % buckets.length;

        Bucket bucket = buckets[index];

        if(!bucket.replace(key, value)) {
            bucket.add(key, value);
        }
    }
}
