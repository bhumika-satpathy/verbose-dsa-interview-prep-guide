package DP.Backtracking;

import java.util.*;

// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//
//It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
//
// Try solving Combination III first before approaching this problem.
// https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> comb = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        backtrack(candidates, target, 0, comb, res);
        return res;
    }

    void backtrack(int[] cands, int target, int startIndex, LinkedList<Integer> comb, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        if(startIndex >= cands.length || target < 0) {
            return;
        }

        for(int i = startIndex; i < cands.length; i++) {
            if(cands[i] > target) {
                continue;
            }
            comb.add(cands[i]);
            backtrack(cands, target - cands[i], i, comb, res);
            comb.removeLast();
        }
    }
}
