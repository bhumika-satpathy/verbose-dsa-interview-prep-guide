package DP.LCS;

public class LCS {

    int[][] dp = new int[1002][1002];
    int memoizedSolution(String s, String t, int n, int m){
        if(n == 0 || m == 0)
            return 0;

//        if(dp[n][m] != -1)
//            return dp[n][m];

        if(s.charAt(n - 1) == t.charAt(m - 1))
            return
//                    dp[n][m] =
                            1 + memoizedSolution(s, t, n - 1, m - 1);

        return
//                dp[n][m] =
                        Math.max(memoizedSolution(s, t, n - 1, m), memoizedSolution(s, t, n, m - 1));
    }

    int topDownDp(String s, String t){
        int n = s.length(), m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }

}
