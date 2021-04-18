package HashMap;

import java.util.HashMap;

// Design a queue-like data structure that moves the most recently used element to the end of the queue.
//
//Implement the MRUQueue class:
//
//MRUQueue(int n) constructs the MRUQueue with n elements: [1,2,3,...,n].
//fetch(int k) moves the kth element (1-indexed) to the end of the queue and returns it.
//
public class MostRecentlyUsedQueue {
    class MRUQueue {

        class DLL {
            int key, value;
            DLL next, prev;

            DLL(int k, int v){
                key = k;
                value = v;
                next = null;
                prev = null;
            }

            DLL(){this(0, 0);}
        }

        HashMap<Integer, DLL> q = new HashMap<>();
        DLL head, tail;
        int cap;

        public MRUQueue(int n) {
            cap = n;
            head = new DLL();
            tail = new DLL();

            for(int i = 1; i <= n; i++){
                DLL node = new DLL(i, i);
                if(i == 1){
                    head.next = node;
                    node.prev = head;
                    tail.prev = node;
                    node.next = tail;
                }else {
                    addNode(node);
                }
                q.put(i, node);
            }
        }

        public int fetch(int k) {
            int val = q.get(k).value;

            for(int i = k; i < cap; i++){
                DLL x = q.get(i);
                x.value = x.next.value;
            }
            tail.prev.value = val;
            return val;
        }

        void addNode(DLL node){
            DLL before = tail.prev;
            DLL after = tail;
            node.prev = before;
            before.next = node;
            node.next = after;
            tail.prev = node;
        }
    }
}
