package Greedy;

public class Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Total gas balance says if in one full circle, if the total gas is positive or negative
        int totalGasBalance = 0;
        int currTotal = 0;
        int startPoint = 0;

        for(int i = 0; i < gas.length; i++) {
            totalGasBalance += gas[i] - cost[i];
            currTotal += gas[i] - cost[i];

            if(currTotal < 0) {
                currTotal = 0;
                startPoint = i + 1;
            }
        }

        return totalGasBalance >= 0 ? startPoint : -1;
    }
}
