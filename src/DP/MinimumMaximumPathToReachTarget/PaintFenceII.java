package DP.MinimumMaximumPathToReachTarget;

// There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
//
//The cost of painting each house with a certain color is represented by an n x k cost matrix costs.
//
//    For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
//
//Return the minimum cost to paint all houses.
// https://leetcode.com/problems/paint-house-ii/
public class PaintFenceII {
    public int minCostII(int[][] costs) {
        int min = -1, secMin = -1, minColor = -1;
        int k = costs[0].length;

        for(int i = 0; i < k; i++) {
            int cost = costs[0][i];

            if(min == -1 || cost < min) {
                secMin = min;
                min = cost;
                minColor = i;
            } else if(secMin == -1 || cost < secMin) {
                secMin = cost;
            }
        }

        for(int house = 1; house < costs.length; house++) {
            int currMin = -1, secCurrMin = -1, currMinColor = -1;
            for(int color = 0; color < k; color++) {
                int cost = costs[house][color];
                if(color == minColor) {
                    cost += secMin;
                } else {
                    cost += min;
                }

                if(currMin == -1 || currMin > cost) {
                    secCurrMin = currMin;
                    currMin = cost;
                    currMinColor = color;
                } else if(secCurrMin == -1 || secCurrMin > cost) {
                    secCurrMin = cost;
                }
            }

            min = currMin;
            secMin = secCurrMin;
            minColor = currMinColor;
        }

        return min;
    }
}
