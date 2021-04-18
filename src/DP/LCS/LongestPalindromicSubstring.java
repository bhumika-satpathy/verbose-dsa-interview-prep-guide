package DP.LCS;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }

        int ans = 0, startIndex = 0, endIndex = 0;

        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = true;
                startIndex = i;
                endIndex = i + 1;
                ans = 2;
            }
        }

        for(int dist = 3; dist <= s.length(); dist++){
            for(int i = 0; i <= s.length() - dist; i++){
                int j = i + dist - 1;

                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    if(ans < dist){
                        ans = dist;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }
}
