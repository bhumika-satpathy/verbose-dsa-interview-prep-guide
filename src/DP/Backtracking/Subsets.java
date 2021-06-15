package DP.Backtracking;

import java.util.*;

// Given an integer array nums of unique elements, return all possible subsets (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.
// https://leetcode.com/problems/subsets/
public class Subsets {
    int n, k;

    void backtrack(int[] nums, List<Integer> combs, List<List<Integer>> res, int startIndex) {
        if(combs.size() == k) {
            res.add(new ArrayList<>(combs));
            return;
        }

        for(int i = startIndex; i < n; i++) {
            combs.add(nums[i]);
            backtrack(nums, combs, res, i + 1);
            combs.remove(combs.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        List<Integer> combs = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        // k denotes the number of elements inside the subset to be considered
        for(k = 0; k <= n; k++) {
            backtrack(nums, combs, res, 0);
        }
        return res;
    }

    // ---------------------- Solution - 2 Backtracking -----------------------------------
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        backtrack2(nums, comb, res, 0);
        return res;
    }

    void backtrack2(int[] nums, List<Integer> combs, List<List<Integer>> res, int startIndex) {
        res.add(new ArrayList<>(combs));

        for(int i = startIndex; i < nums.length; i++) {
            combs.add(nums[i]);
            backtrack(nums, combs, res, i + 1);
            combs.remove(combs.size() - 1);
        }
    }
}
