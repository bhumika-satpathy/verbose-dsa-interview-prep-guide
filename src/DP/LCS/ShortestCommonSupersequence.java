package DP.LCS;

// Given two strings str1 and str2, the task is to find the length of the shortest string that has both str1 and str2 as subsequences.
public class ShortestCommonSupersequence {

    int memoizedSolution(String s, String t, int n, int m){
        if(n == 0 || m == 0)
            return 0;

        if(s.charAt(n - 1) == t.charAt(m - 1))
            return 1 + memoizedSolution(s, t, n - 1, m - 1);
        return Math.max(memoizedSolution(s, t, n - 1, m), memoizedSolution(s, t, n, m - 1));
    }

    int topDownDp(String s, String t, int n, int m){
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }

    int shortestSuperSequence(String s, String t){
        int len = topDownDp(s, t, s.length(), t.length());
        return s.length() + t.length() - len;
    }

}
