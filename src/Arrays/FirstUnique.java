package Arrays;

import java.util.*;

class FirstUnique {

    HashMap<Integer, Boolean> map;
    Queue<Integer> q;
    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        q = new LinkedList<>();

        for(int num: nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        while(!q.isEmpty() && !map.get(q.peek())) {
            q.poll();
        }
        if(!q.isEmpty()) {
            return q.peek();
        }
        return -1;
    }

    public void add(int value) {
        if(map.containsKey(value)) {
            map.put(value, false);
        } else {
            map.put(value, true);
            q.add(value);
        }
    }
}