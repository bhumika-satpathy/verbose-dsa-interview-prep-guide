package DP.MinimumMaximumPathToReachTarget;

// Given an integer n, return the least number of perfect square numbers that sum to n.
//A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
public class PerfectSquares {
    public int numSquares(int n) {
        int m = (int)Math.sqrt(n);
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= n; i++)
            dp[0][i] = Integer.MAX_VALUE - 1;
        for(int i = 0; i <= m; i++)
            dp[i][0] = 0;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(j >= i*i){
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - (i*i)]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
