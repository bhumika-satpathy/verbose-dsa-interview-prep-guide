package DP.LCS;

// Longest Palindromic Subsequence
public class LPS {

    int memoizedSolution(String str, int i, int j){
        if(i == j)
            return 1;

        if(str.charAt(i) == str.charAt(j) && i + 1 == j)
            return 2;

        if(str.charAt(i) == str.charAt(j))
            return 2 + memoizedSolution(str, i + 1, j - 1);

        return Math.max(memoizedSolution(str, i + 1, j), memoizedSolution(str, i, j - 1));
    }

    int topDownDp(String str){

        int[][] dp = new int [str.length()][str.length()];

        // LPS for a string of length one ( first sub-problem ) handling length 1
        for(int i = 0; i < str.length(); i++)
            dp[i][i] = 1;

        // Handles length starting from 2
        for(int dist = 2; dist < str.length(); dist++){
            for(int i = 0; i <= str.length() - dist; i++){
                int j = i + dist - 1;

                if(str.charAt(i) == str.charAt(j)){
                    if(dist == 2)
                        dp[i][j] = 2;
                    else dp[i][j] = 2 + dp[i + 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }

        return dp[0][str.length() - 1];
    }

    // Yet another way is to find the longest common subsequence between the string and its reverse

}
