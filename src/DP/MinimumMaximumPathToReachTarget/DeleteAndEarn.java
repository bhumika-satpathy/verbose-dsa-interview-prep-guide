package DP.MinimumMaximumPathToReachTarget;

// Given an array nums of integers, you can perform operations on the array.
//
//In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
//
//You start with 0 points. Return the maximum number of points you can earn by applying such operations.
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] buckets = new int[10001];
        for (int num : nums) {
            buckets[num] += num;
        }
        int[] dp = new int[10001];
        dp[0] = buckets[0];
        dp[1] = buckets[1];
        for (int i = 2; i < buckets.length; i++) {
            // 1. Choose the current i => sum of bucket[i] + sum until dp[i - 2]
            // 2. Choose the previous i and do not choose/delete the i - 2 and i possibility => not choosing bucket[i] and dp[i - 2]
            dp[i] = Math.max(buckets[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[10000];
    }

    //----------------------------------- Solution-2 -------------------------------------
    public int deleteAndEarn2(int[] nums) {
        int[] count = new int[10001];
        for (int x: nums) count[x]++;
        int avoid = 0, using = 0, prev = -1;

        for (int k = 0; k <= 10000; ++k) if (count[k] > 0) {
            int m = Math.max(avoid, using);
            if (k - 1 != prev) {
                using = k * count[k] + m;
                avoid = m;
            } else {
                using = k * count[k] + avoid;
                avoid = m;
            }
            prev = k;
        }
        return Math.max(avoid, using);
    }
}
