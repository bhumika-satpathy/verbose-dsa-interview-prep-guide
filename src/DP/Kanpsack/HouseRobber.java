package DP.Kanpsack;

import java.util.Arrays;

// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
// the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
// it will automatically contact the police if two adjacent houses were broken into on the same night.
//Given an integer array nums representing the amount of money of each house,
// return the maximum amount of money you can rob tonight without alerting the police.
public class HouseRobber {
    int[] dp = new int[101];
    public int rob(int[] nums) {
        int n = nums.length;
        Arrays.fill(dp, -1);

        return memoization(nums, n);
    }

    int memoization(int[] nums, int n) {
        if(n <= 0) {
            return 0;
        }

        if(dp[n] > -1) {
            return dp[n];
        }

        return dp[n] = Math.max(memoization(nums, n - 1), nums[n - 1] + memoization(nums, n - 2));
    }

    // ---------------------------- Solution 2 -------------------------------------------------------------------------
    public int robUsingMemoizationAndArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        int[] dp = new int[101];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }
// --------------------- Bottom-Up Approach ----------------------------------------------------------------------------

//    public int rob(int[] nums) {
//        if(nums.length == 1) {
//            return nums[0];
//        }
//        if(nums.length == 2) {
//            return Math.max(nums[0], nums[1]);
//        }
//        int[] dp = new int[101];
//        int n = nums.length;
//        Arrays.fill(dp, -1);
//
//        memoize(nums, dp, 0);
//        return dp[0];
//    }
//
//    int memoize(int[] nums, int[] dp, int n) {
//        if(n >= nums.length) {
//            return 0;
//        }
//
//        if(dp[n] != -1) {
//            return dp[n];
//        }
//
//        return dp[n] = Math.max(nums[n] + memoize(nums, dp, n + 2), memoize(nums, dp, n + 1));
//    }
}
