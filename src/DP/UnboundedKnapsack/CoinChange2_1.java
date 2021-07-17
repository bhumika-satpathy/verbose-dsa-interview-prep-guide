package DP.UnboundedKnapsack;

// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//
//Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
//
//You may assume that you have an infinite number of each kind of coin.
//
//The answer is guaranteed to fit into a signed 32-bit integer.
// https://leetcode.com/problems/coin-change-2/
public class CoinChange2_1 {
    Integer[][] dp = new Integer[301][5001];
    public int change(int amount, int[] coins) {
        return memoizedSol(coins, amount, coins.length);
    }

    public int memoizedSol(int[] coins, int amount, int n) {
        if(amount > 0 && n == 0) {
            return 0;
        }
        if(amount == 0) {
            return 1;
        }

        if(dp[n][amount] != null) {
            return dp[n][amount];
        }

        if(coins[n - 1] <= amount) {
            return dp[n][amount] = memoizedSol(coins, amount - coins[n - 1], n) + memoizedSol(coins, amount, n - 1);
        }

        return dp[n][amount] = memoizedSol(coins, amount, n - 1);
    }

    // Solution 2 ----------------------------------
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int coin: coins) {
            for(int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
        // return memoizedSol(coins, amount, coins.length);
    }
}
