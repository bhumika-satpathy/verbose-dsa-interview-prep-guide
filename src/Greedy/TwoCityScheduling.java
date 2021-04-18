package Greedy;

import java.util.Arrays;

// A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.
//Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (cost1, cost2) -> cost1[0] - cost1[1] - (cost2[0] - cost2[1]));

        int n = costs.length/2, sum = 0;

        for(int i = 0; i < n; i++){
            sum += costs[i][0] + costs[i + n][1];
        }
        return sum;
    }
}
