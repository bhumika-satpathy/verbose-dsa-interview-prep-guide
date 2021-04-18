package DP.LCS;

// Given two strings X and Y, print the shortest string that has both X and Y as subsequences. If multiple shortest supersequence exists, print any one of them.
public class PrintSCS {

    void Solution(String str1, String str2){
        int n = str1.length(), m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(str1.charAt(i) == str2.charAt(j))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int index = dp[n][m];
        int i = n, j = m;

        StringBuilder str = new StringBuilder("");

        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                str.append(str1.charAt(i - 1));
                i--;
                j--;
            }
            else if(dp[i - 1][j] >= dp[i][j - 1]){
                str.append(str2.charAt(j - 1));
                j--;
            }
            else {
                str.append(str1.charAt(i - 1));
                i--;
            }
        }

        while(i > 0){
            str.append(str1.charAt(i--));
        }

        while(j > 0)
            str.append(str2.charAt(j--));
    }

}
