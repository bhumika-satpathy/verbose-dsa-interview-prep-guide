package Greedy;

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
}
