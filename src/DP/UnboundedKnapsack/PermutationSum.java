package DP.UnboundedKnapsack;

// Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
//The answer is guaranteed to fit in a 32-bit integer.
/*
Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
 */
public class PermutationSum {
    public int permutationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for(int j = 1; j <= target; j++)
            for(int i = 0; i < nums.length; i++)
                if(j >= nums[i])
                    dp[j] += dp[j - nums[i]];

        return dp[target];
    }
}

/*
order-1:

for each sum in dp[]
    for each num in nums[]
        if (sum >= num)
            dp[sum] += dp[sum-num];
order-2:

for each num in nums[]
    for each sum in dp[]  >= num
        dp[sum] += dp[sum-num];
order-1 is used to calculate the number of combinations considering different sequences
order-2 is used to calculate the number of combinations NOT considering different sequences
Give an example nums[] = {1, 2, 3}, target = 4
order-1 considers the number of combinations starting from 1, 2, and 3, respectively, so all sequences are considered as the graph below.

1 --> 1 --> 1 --> 1 --> (0)
1 --> 1 --> 2 --> (0)
1 --> 2 --> 1 --> (0)
1 --> 3 --> (0)

2 --> 1 --> 1 --> (0)
2 --> 2 --> (0)

3 --> 1 --> (0)

order-2 considers the number of combinations starting from 0 (i.e., not picking anyone), and the index of the num picked next must be >= the index of previous picked num, so different sequences are not considered, as the graph below.

(0) --> 1 --> 1 --> 1 --> 1
(0) --> 1 --> 1 --> 2
(0) --> 1 --> 3
(0) --> 2 --> 2
 */