package DP.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//
//Only numbers 1 through 9 are used.
//Each number is used at most once.
//Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
// https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        backtrack(n, comb, 0, k, res);
        return res;
    }

    void backtrack(int remaining, LinkedList<Integer> comb, int startIndex, int k, List<List<Integer>> res) {
        if(remaining == 0 && comb.size() == k) {
            res.add(new ArrayList<>(comb));
            return;
        }
        if(remaining < 0 || comb.size() == k) {
            return;
        }

        for(int i = startIndex; i < 9; i++) {
            comb.add(i + 1);
            backtrack(remaining - (i + 1), comb, i + 1, k, res);
            comb.removeLast();
        }
    }
}
