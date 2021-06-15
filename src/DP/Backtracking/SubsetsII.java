package DP.Backtracking;

import java.util.*;

// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.
// https://leetcode.com/problems/subsets-ii/
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        backtrack(nums, comb, res, 0);
        return res;
    }

    void backtrack(int[] nums, List<Integer> combs, List<List<Integer>> res, int startIndex) {
        res.add(new ArrayList<>(combs));

        for(int i = startIndex; i < nums.length; i++) {
            // If the previous and the current indices are the same, then the previous element would already have all the combinations that the curr one is about to make and hence we can skip it
            // Only if its the start index, then consider it because it comes from inside the condition
            if(i == startIndex || nums[i] != nums[i - 1]) {
                combs.add(nums[i]);
                backtrack(nums, combs, res, i + 1);
                combs.remove(combs.size() - 1);
            }
        }
    }
}
