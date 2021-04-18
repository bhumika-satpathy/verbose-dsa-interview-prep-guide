package DP.MinimumMaximumPathToReachTarget;

public class OnesAndZeroes {
    int[] countZeroeOnes(String s){
        int[] count = new int[2];

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - '0']++;
        }
        return count;
    }

    int[][][] dp = new int[601][101][101];

    int calc(String[] strs, int i, int m, int n){
        if(i == strs.length)
            return 0;

        if(dp[i][m][n] != 0)
            return dp[i][m][n];

        int considered = -1, notConsidered = 0;
        if(m - countZeroeOnes(strs[i])[0] >= 0 &&  n - countZeroeOnes(strs[i])[1] >= 0)
            considered = calc(strs, i + 1, m - countZeroeOnes(strs[i])[0], n - countZeroeOnes(strs[i])[1]) + 1;
        notConsidered = calc(strs, i + 1, m, n);

        return dp[i][m][n] = Math.max(considered, notConsidered);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        return calc(strs, 0, m, n);
    }
}
