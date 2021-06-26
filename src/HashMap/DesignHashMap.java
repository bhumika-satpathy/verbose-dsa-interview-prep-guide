package HashMap;

import java.util.*;

class Pair {
    int key, val;
    Pair(int k, int v) {
        key = k;
        val = v;
    }
}

class Bucket {
    List<Pair> bucket;

    Bucket() {
        bucket = new ArrayList<>();
    }

    int get(int key) {
        for(Pair pair: bucket) {
            if(pair.key == key) {
                return pair.val;
            }
        }

        return -1;
    }

    void update(int key, int val) {
        boolean found = false;
        for(Pair pair: bucket) {
            if(pair.key == key) {
                found = true;
                pair.val = val;
                break;
            }
        }

        if(!found) {
            bucket.add(new Pair(key, val));
        }
    }

    void remove(int key) {
        for(Pair pair: bucket) {
            if(pair.key == key) {
                bucket.remove(pair);
                break;
            }
        }
    }
}

class DesignHashMap {

    private List<Bucket> hashTable;
    private int keySpace;

    /** Initialize your data structure here. */
    public DesignHashMap() {
        keySpace = 2069;
        hashTable = new ArrayList<>();

        for(int i = 0; i < keySpace + 1; i++) {
            hashTable.add(new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = key % keySpace;
        hashTable.get(hashKey).update(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashKey = key % keySpace;
        return hashTable.get(hashKey).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey = key % keySpace;
        hashTable.get(hashKey).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */