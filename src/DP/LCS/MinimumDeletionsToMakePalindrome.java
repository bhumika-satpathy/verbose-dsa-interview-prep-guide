package DP.LCS;

// Given a string of size ‘n’. The task is to remove or delete the minimum number of characters from the string so that the resultant string is a palindrome.
public class MinimumDeletionsToMakePalindrome {

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
        int n = str.length();

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++)
            dp[i][i] = 1;

        for(int dis = 2; dis < n; dis++){
            for(int i = 0; i < n - dis + 1; i++){
                int j = i + dis - 1;

                if(str.charAt(i) == str.charAt(j)){
                    if(dis == 2)
                        dp[i][j] = 2;
                    else dp[i][j] = 2 + dp[i + 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];
    }

    int minimumDeletions(String str){
        int topDownDp = topDownDp(str);

        return str.length() - topDownDp;
    }

}
