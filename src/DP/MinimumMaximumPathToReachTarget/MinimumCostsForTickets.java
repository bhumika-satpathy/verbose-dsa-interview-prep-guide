package DP.MinimumMaximumPathToReachTarget;

import java.util.HashSet;

// You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
//
//Train tickets are sold in three different ways:
//
//a 1-day pass is sold for costs[0] dollars,
//a 7-day pass is sold for costs[1] dollars, and
//a 30-day pass is sold for costs[2] dollars.
//The passes allow that many days of consecutive travel.
//
//For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
//Return the minimum number of dollars you need to travel every day in the given list of days.
public class MinimumCostsForTickets {
    HashSet<Integer> daySet = new HashSet<>();
    Integer[] dp = new Integer[366];
    public int mincostTickets(int[] days, int[] costs) {
        for(int day: days) {
            daySet.add(day);
        }

        return minCost(365, costs);
    }

    int minCost(int dayNum, int[] costs) {
        if(dayNum <= 0) {
            return 0;
        }

        if(dp[dayNum] != null) {
            return dp[dayNum];
        }

        if(daySet.contains(dayNum)) {
            return dp[dayNum] = Math.min(costs[0] + minCost(dayNum - 1, costs), Math.min(costs[1] + minCost(dayNum - 7, costs), costs[2] + minCost(dayNum - 30, costs)));
        } else {
            // Because we need minimum until the last calculated day
            return dp[dayNum] = minCost(dayNum - 1, costs);
        }
    }
}
