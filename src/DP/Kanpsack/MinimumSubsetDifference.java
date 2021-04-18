package DP.Kanpsack;

// Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
//If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
// x + y = total
// x - y = min
// min = Math.abs(total - 2 * x)
public class MinimumSubsetDifference {

    int findMinSum(int[] arr, int i, int sumCalc, int sumTotal){
        if(i == 0)
            return Math.abs((sumTotal - 2 * sumCalc));

        return Math.min(findMinSum(arr, i - 1, sumCalc + arr[i - 1], sumTotal), findMinSum(arr, i - 1, sumCalc, sumTotal));
    }

    int findMinSum(int[] arr, int n){
        int total = 0;
        for(int i = 0; i < n; i++)
            total += arr[i];
        return findMinSum(arr, n, 0, total);
    }

    int topDown(int[] arr, int n){
        int total = 0;
        for(int i = 0; i < n; i++)
            total += arr[i];
        boolean[][] dp = new boolean[n + 1][total + 1];

        for(int i = 0; i <= total; i++)
            dp[0][i] = false;
        for(int i = 0; i <= n; i++)
            dp[i][0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= total; j++){
                dp[i][j] = dp[i - 1][j];
                if(arr[i - 1] <= j)
                    dp[i][j] |= dp[i][j - arr[i - 1]];
            }
        }

        int diff = Integer.MAX_VALUE;
        for(int i = total/2; i >= 0; i--){
            if(dp[n][i]){
                diff = total - 2 * i;
                break;
            }
        }

        return diff;
    }

}
