package DP.Kanpsack;

// Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is the same.
public class EqualSumPartition {

    boolean[][] dp = new boolean[1002][10002];
    boolean sumExists(int[] arr, int n, int sum){
        if(n == 0 && sum > 0)
            return false;
        if(sum == 0)
            return true;

        if(dp[n][sum])
            return true;

        if(arr[n - 1] <= sum)
            return dp[n][sum] = sumExists(arr, n - 1, sum - arr[n - 1]) || sumExists(arr, n - 1, sum);

        return dp[n][sum] = sumExists(arr, n - 1, sum);
    }

    boolean memoizedSolution(int[] arr, int n){
        int totalSum = 0;

        for(int i = 0; i < arr.length; i++)
            totalSum += arr[i];

        return totalSum % 2 != 0 ? false : sumExists(arr, n, totalSum/2);
    }

    boolean topDownDp(int[] arr, int n){
        int totalSum = 0;

        for(int i = 0; i < arr.length; i++)
            totalSum += arr[i];

        if(totalSum % 2 != 0)
            return false;

        boolean[][] dp = new boolean[n + 1][totalSum/2 + 1];
        int sum = totalSum/2;

        for(int i = 0; i <= sum; i++)
            dp[0][i] = false;

        for(int i = 0; i <= n; i++)
            dp[i][0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }

}
