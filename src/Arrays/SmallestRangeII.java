package Arrays;

import java.util.Arrays;

// Given an array nums of integers, for each integer nums[i] we need to choose either x = -k or x = k, and add x to nums[i] (only once).
//
//After this process, we have some array result.
//
//Return the smallest possible difference between the maximum value of result and the minimum value of result.
// https://leetcode.com/problems/smallest-range-ii/
public class SmallestRangeII {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = nums[n - 1] - nums[0];

        int low = 0, high = 0;
        for(int i = 0; i < n - 1; i++) {
            low = Math.min(nums[0] + k, nums[i + 1] - k);
            high = Math.max(nums[n - 1] - k, nums[i] + k);

            res = Math.min(res, high - low);
        }

        return res;
    }
}

// Complexity Analysis
//
//    Time Complexity: O(NlogN), where N is the length of the nums.
//
//    Space complexity : O(N) or O(logN)
//
//        The space complexity of the sorting algorithm depends on the implementation of each program language.
//
//        For instance, the list.sort() function in Python is implemented with the Timsort algorithm whose space complexity is O(N).
//
//        In Java, the Arrays.sort() is implemented as a variant of quicksort algorithm whose space complexity is O(log⁡N)\mathcal{O}(\log{N})O(logN).