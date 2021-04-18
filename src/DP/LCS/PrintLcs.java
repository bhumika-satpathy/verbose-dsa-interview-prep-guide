package DP.LCS;

// Print lcs between 2 strings
public class PrintLcs {

    // TODO
//    static String memoizedSolution(String s, String t, int n, int m){
//
//    }

   String topDownDp(String s, String t){
       int n = s.length(), m = t.length();

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

       int val = dp[n][m];
       char[] ans = new char[val + 1];
       int i = n, j = m;

       while(i >= 0 && j >= 0){
           if(s.charAt(i - 1) == s.charAt(j - 1)){
               ans[val--] = s.charAt(i - 1);
               i--;
               j--;
           } else if(dp[i - 1][j] >= dp[i][j - 1])
               i--;
           else j--;
       }
       return String.valueOf(ans);
   }

}
