package Greedy;

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
//
//Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimetoBuyandSellStock_II {
    public int maxProfit(int[] prices) {
        int valley = 0, peak = 0, i = 0, maxProfit = 0;

        while(i < prices.length - 1){
            while(i < prices.length - 1 && prices[i] > prices[i + 1])
                i++;
            valley = prices[i];
            while(i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];

            maxProfit += peak - valley;
        }

        return maxProfit;
    }

    // Solution 2
    public int maxProfit2(int[] prices) {
        int profit = 0, n = prices.length;

        for(int i = 1; i < n; i++) {
            if(prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
