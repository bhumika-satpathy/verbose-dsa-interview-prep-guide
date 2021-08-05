package DP.Kanpsack;

// Check if a particular sum can be formed from an array using its elements or not
public class SubsetSum {
    boolean[][] dp = new boolean[1002][10002];
    boolean memoizedSolution(int[] arr, int n, int sum){
        if(n == 0 && sum > 0)
            return false;
        if(sum == 0)
            return true;

        if(dp[n][sum])
            return true;

        // If the desired sum >= array's element
        if(arr[n - 1] <= sum)
            // 2 options: to choose the element or not choose the element
            return dp[n][sum] = memoizedSolution(arr, n - 1, sum - arr[n - 1]) || memoizedSolution(arr, n - 1, sum);
        // desired sum < element, do not choose the current element
        return dp[n][sum] = memoizedSolution(arr, n - 1, sum);
    }

    boolean topDownDp(int[] arr, int sum){
        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for(int i = 0; i <= n; i++)
            dp[0][i] = false;
        for(int i = 0; i <= sum; i++)
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
