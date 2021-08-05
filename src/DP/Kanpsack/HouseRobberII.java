package DP.Kanpsack;

import java.util.Arrays;

// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
// https://leetcode.com/problems/house-robber-ii/
public class HouseRobberII {
    int[] dp = new int[101];
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        Arrays.fill(dp, -1);
        robHouse(nums, 1, nums.length - 1);
        int rob1 = dp[nums.length - 1];
        Arrays.fill(dp, -1);
        robHouse(nums, 0, nums.length - 2);
        int rob2 = dp[nums.length - 2];

        return Math.max(rob1, rob2);
    }

    int robHouse(int[] nums, int start, int n) {
        if(n < start) {
            return 0;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = Math.max(robHouse(nums, start, n - 1), nums[n] + robHouse(nums, start, n - 2));
    }
}
