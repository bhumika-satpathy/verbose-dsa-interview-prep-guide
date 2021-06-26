package DP.Backtracking;

import java.util.*;

// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
//Each number in candidates may only be used once in the combination.
//
//Note: The solution set must not contain duplicate combinations.
//
// Note: Do combination III first for better understanding
// https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> combs = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, target, combs, res, 0);
        return res;
    }

    void backtrack(int[] nums, int target, List<Integer> combs, List<List<Integer>> res, int startIndex) {
        if(target == 0) {
            res.add(new ArrayList<>(combs));
            return;
        }
        if(target < 0 || startIndex == nums.length) {
            return;
        }
        for(int i = startIndex; i < nums.length; i++) {
            // Since numbs are sorted, if nums[i] > target then all others are too
            if(nums[i] > target) {
                break;
            }
            if(i == startIndex || nums[i] != nums[i - 1]) {
                combs.add(nums[i]);
                backtrack(nums, target - nums[i], combs, res, i + 1);
                combs.remove(combs.size() - 1);
            }
        }
    }
}
