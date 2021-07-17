package Arrays;

import java.util.HashMap;

// Given an integer array nums and an integer k, return the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
//
// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
// Explanation(brief): Let's say you've iterated to index 5 (randomly chosen) and your sum from index 0 to 5 so far is 7, and k is 3. sum - k in this case is 4.
//
//What map.containsKey(sum - k) returns is the index where the sum of every element up to that index from index 0 is sum - k, or (7 - 4) == 3, in our example.
// Let's say that that index returned by map.containsKey(sum - k) is 2 (randomly chose one that is before index 5).
// So knowing that at index 2 the total sum is 4, and at index 5, the total sum is 7, that means the elements between index 2 and index 5 incremented the total sum by 3, or k!
public class MaximumSizeSubArraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            ans = nums[i] == k ? Math.max(ans, 1) : ans;
            sum += nums[i];
            int diff = sum - k;
            if(diff == 0)
                ans = i + 1;
            else if(map.containsKey(diff)) {
                ans = Math.max(ans, i - map.get(diff));
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return ans;
    }
}
