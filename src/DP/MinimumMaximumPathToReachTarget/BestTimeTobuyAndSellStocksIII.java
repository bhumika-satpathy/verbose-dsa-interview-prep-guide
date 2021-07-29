package DP.MinimumMaximumPathToReachTarget;

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//Find the maximum profit you can achieve. You may complete at most two transactions.
//
//Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class BestTimeTobuyAndSellStocksIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] leftProfs = new int[n];
        // An extra 1 to make sure that at a certain point, the left profit is compared to the right which specifically begins after this certain point
        int[] rightProfs = new int[n + 1];

        // the left point is ought to be less than that of the right
        int leftMin = prices[0];
        // the right point is ought to be greater than that of the left
        int rightMax = prices[n - 1];
        int maxProfit = 0;

        // Accomodate leftProfs and rightProfs in one pass
        for(int l = 1; l < n; l++) {
            leftProfs[l] = Math.max(leftProfs[l - 1], prices[l] - leftMin);
            leftMin = Math.min(leftMin, prices[l]);

            int r = n - l - 1;
            rightProfs[r] = Math.max(rightProfs[r + 1], rightMax - prices[r]);
            rightMax = Math.max(rightMax, prices[r]);
        }

        for(int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftProfs[i] + rightProfs[i + 1]);
        }

        return maxProfit;
    }
}
