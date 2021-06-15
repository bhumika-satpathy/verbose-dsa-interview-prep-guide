package HashMap;
import java.util.HashMap;

// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
//Implement the LRUCache class:
//LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//int get(int key) Return the value of the key if the key exists, otherwise return -1.
//void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
//Follow up:
//Could you do get and put in O(1) time complexity?
class LRUCache {

    class DLinkedList {
        int key, value;
        DLinkedList next, prev;
    }

    DLinkedList head;
    DLinkedList tail;
    int cacheCapacity = 0;
    int count = 0;
    HashMap<Integer, DLinkedList> cache = new HashMap<>();

    public LRUCache(int capacity) {
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        cacheCapacity = capacity;
        count = 0;
    }

    public int get(int key) {
        DLinkedList node = cache.get(key);

        if(node == null){
            return -1;
        }

        int ans = node.value;
        removeNode(node);
        addNode(node);
        return ans;
    }

    public void put(int key, int value) {
        DLinkedList node = cache.get(key);

        if(node == null){
            count++;
            node = new DLinkedList();
            node.key = key;
            node.value = value;

            cache.put(key, node);

            addNode(node);
        } else {
            node.value = value;
            removeNode(node);
            addNode(node);
        }
        if(count > cacheCapacity){
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
            count--;
        }
    }

    void addNode(DLinkedList node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    void removeNode(DLinkedList node){
        DLinkedList before = node.prev;
        DLinkedList after = node.next;
        before.next = after;
        after.prev = before;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */