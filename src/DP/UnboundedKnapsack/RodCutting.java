package DP.UnboundedKnapsack;

// Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
// Determine the maximum value obtainable by cutting up the rod and selling the pieces.
// For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
public class RodCutting {

    int memoizedSolution(int[] prices, int[] length, int maxLen, int n){
        if(n == 0 || maxLen == 0)
            return 0;

        if(length[n - 1] <= maxLen)
            return Math.max(prices[n - 1] + memoizedSolution(prices, length, maxLen - length[n - 1], n),
                    memoizedSolution(prices, length, maxLen, n - 1));
        return memoizedSolution(prices, length, maxLen, n - 1);
    }

    int topDownDp(int[] prices, int[] length, int maxLen, int n){
        int[][] dp = new int[n + 1][maxLen + 1];

        for(int i = 0; i <= maxLen; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if(length[n - 1] <= maxLen)
                        dp[i][j] = Math.max(prices[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][maxLen];

    }

}
