package Arrays;

import java.util.*;

// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
//
//You must write an algorithm that runs in O(n) time and uses only constant extra space.
//
// https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int num: nums) {
            // num - 1 comes from the fact that there are only n numbers and the last index would be at max n - 1 if all the elements occur once
            nums[Math.abs(num) - 1] *= -1;
        }

        for(int num: nums) {
            if(nums[Math.abs(num) - 1] > 0) {
                ans.add(Math.abs(num));
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        // Note: Math.abs(num) is added everywhere in order to retain the original num and
        // not let the negative numer idex the array since that would be outside bounds
        return ans;
    }
}
