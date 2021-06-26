package Arrays;

import java.util.*;

class FirstUnique {

    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public FirstUnique(int[] nums) {
        for(Integer num: nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        return list.size() == 0 ? -1 : list.get(0);
    }

    public void add(int value) {
        if(map.containsKey(value)) {
            int freq = map.get(value);
            map.put(value, freq + 1);
            list.remove((Integer)value);
        } else {
            map.put(value, 1);
            list.add(value);
        }
    }
}