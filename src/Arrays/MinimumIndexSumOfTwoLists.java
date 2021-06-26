package Arrays;

import java.util.*;

// Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
//
//You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers,
// output all of them with no order requirement. You could assume there always exists an answer.
// https://leetcode.com/problems/minimum-index-sum-of-two-lists/
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int sum = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for(int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                if(sum > i + map.get(list2[i])) {
                    res.clear();
                    sum = i + map.get(list2[i]);
                    res.add(list2[i]);
                } else if(sum == i + map.get(list2[i])) {
                    res.add(list2[i]);
                }
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
