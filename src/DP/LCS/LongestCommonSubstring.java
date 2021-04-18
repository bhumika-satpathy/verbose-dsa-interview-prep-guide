package DP.LCS;

// Java program using to find length of the longest common substring recursion
public class LongestCommonSubstring {

    int memoizedSolution(String a, String b, int count, int n, int m){
        if(n == 0 || m == 0)
            return count;

        if(a.charAt(n - 1) == b.charAt(m - 1))
            count = memoizedSolution(a, b, count + 1, n - 1, m - 1);

        return count = Math.max(count, Math.max(memoizedSolution(a, b, 0, n - 1, m), memoizedSolution(a, b, 0, n, m - 1)));
    }

    int topDownDp(String a, String b){
        int n = a.length(), m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        int res = 0;

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(a.charAt(i - 1) == b.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    res = Math.max(res, dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }

        return res;
    }

}
