package DP.MinimumMaximumPathToReachTarget;

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Approach: Similar in kind to that of largest contiguos subarray sum
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxUntilHere = 0, maxSoFar = 0;

        for(int i = 1; i < n; i++) {
            maxUntilHere += (prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxSoFar, maxUntilHere);

            if(maxUntilHere < 0) {
                maxUntilHere = 0;
            }
        }

        return maxSoFar;
    }
}
