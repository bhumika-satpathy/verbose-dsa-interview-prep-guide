package DP.LCS;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if(s.length() == 0) {
            return 0;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }

        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                ans++;
                dp[i][i + 1] = true;
            }
        }

        for(int dist = 3; dist <= n; dist++) {
            for(int i = 0; i <= n - dist; i++) {
                int j = i + dist - 1;

                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    ans++;
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return ans;
    }
}
