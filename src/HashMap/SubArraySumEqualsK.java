package HashMap;

import java.util.HashMap;

// Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int sum = 0, ans = 0;

        count.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(count.containsKey(sum - k)){
                ans += count.get(sum - k);
            }
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}