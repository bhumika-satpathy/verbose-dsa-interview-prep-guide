package DP.LCS;

import java.util.Arrays;

public class MaximumLengthOfRepeatedSubArray {
    int[][][] dp = new int[101][101][101];
    public int findLength(int[] A, int[] B) {

        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        longestCommonSubstring(A, B, A.length, B.length, 0);
        return dp[A.length][B.length][0];
    }

    int longestCommonSubstring(int[] A, int[] B, int l1, int l2, int cnt) {
        if(l1 == 0 || l2 == 0) {
            return cnt;
        }

        if(dp[l1][l2][cnt] != -1) {
            return dp[l1][l2][cnt];
        }
        int cnt1 = cnt;
        if(A[l1 - 1] == B[l2 - 1]) {
            cnt1 = longestCommonSubstring(A, B, l1 - 1, l2 - 1, cnt + 1);
        }

        return dp[l1][l2][cnt] = Math.max(cnt1, Math.max(longestCommonSubstring(A, B, l1 - 1, l2, 0), longestCommonSubstring(A, B, l1, l2 - 1, 0)));
    }

    // Above solution gives runtime error
    // Solution 2---------------------->
    public int findLength2(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
        return ans;
    }
}
