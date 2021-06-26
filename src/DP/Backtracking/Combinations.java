package DP.Backtracking;

import java.util.ArrayList;
import java.util.List;

// Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
//
//You may return the answer in any order.
// https://leetcode.com/problems/combinations/
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> combs = new ArrayList<>();

        backtrack(n, output, k, combs, 1);
        return output;
    }

    void backtrack(int n, List<List<Integer>> output, int k, List<Integer> combs, int first) {
        if(combs.size() == k) {
            output.add(new ArrayList<>(combs));
            return;
        }

        for(int i = first; i <= n; i++) {
            combs.add(i);
            backtrack(n, output, k, combs, i + 1);
            combs.remove(combs.size() - 1);
        }
    }
}
