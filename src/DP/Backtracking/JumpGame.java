package DP.Backtracking;

import java.util.Arrays;

// Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
public class JumpGame {
    int[] dp;
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return canJumpFromPosition(0, nums);
    }

    boolean canJumpFromPosition(int index, int[] nums) {
        if(index == nums.length - 1) {
            dp[nums.length - 1] = 1;
            return true;
        }

        if(dp[index] != -1) {
            return dp[index] == 1 ? true : false;
        }

        int currPosition = index;
        int jumpLength = nums[index];
        int farthestPoint = Math.min(currPosition + jumpLength, nums.length - 1);

        for(int i = currPosition + 1; i <= currPosition + jumpLength; i++) {
            if(canJumpFromPosition(i, nums)) {
                dp[i] = 1;
                return true;
            }
        }
        dp[index] = 0;
        return false;
    }
}
