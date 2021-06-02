package DP.MinimumMaximumPathToReachTarget;

import java.util.Arrays;

// Given an integer array nums, return the length of the longest strictly increasing subsequence.
//
//A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
// For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        int max = 1;

        for(int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
