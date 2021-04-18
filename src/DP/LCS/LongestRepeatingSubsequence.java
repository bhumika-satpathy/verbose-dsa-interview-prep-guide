package DP.LCS;

// Given a string, find the length of the longest repeating subsequence such that the two subsequences don’t have same string character at the same position,
// i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
public class LongestRepeatingSubsequence {

    // Fill the dp with -1 throughout the array to initialize
    int[][] dp = new int[102][102];
    int memoizedSolution(String str, int n, int m){
        if(dp[n][m] != -1)
            return dp[n][m];

        if(n == 0 || m == 0)
            return 0;

        if(str.charAt(n - 1) == str.charAt(m - 1) && n != m)
            return dp[n][m] = 1 + memoizedSolution(str, n - 1, m - 1);
        return dp[n][m] = Math.max(memoizedSolution(str, n, m - 1), memoizedSolution(str, n - 1, m));
    }

    int topDownDp(String str){
        int n = str.length(), m = str.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(str.charAt(i - 1) == str.charAt(j - 1) && i != j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[n][m];
    }

}
