package DP.MinimumMaximumPathToReachTarget;

import java.util.List;

// Given a triangle array, return the minimum path sum from top to bottom.
//For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowNum = triangle.size();
        int[] dp = new int[rowNum];
        for (int i = 0; i < triangle.get(rowNum - 1).size(); i++) {
            dp[i] = triangle.get(rowNum - 1).get(i);
        }
        for (int row = rowNum - 2; row >= 0; row--) {// for each layer
            for (int col = 0; col <= row; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1])
                        + triangle.get(row).get(col);
            }
        }
        return dp[0];
    }
}
