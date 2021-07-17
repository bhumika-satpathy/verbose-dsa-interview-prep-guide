package Arrays;

import java.util.HashMap;

// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
//
// https://leetcode.com/problems/contiguous-array/
public class ContiguosArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1) ? 1 : -1;
            if(map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
