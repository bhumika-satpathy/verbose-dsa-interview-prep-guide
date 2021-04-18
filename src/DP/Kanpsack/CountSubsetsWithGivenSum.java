package DP.Kanpsack;

// Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
public class CountSubsetsWithGivenSum {

    static int memoizedSolution(int[] arr, int n, int sum){
        if(n == 0 && sum > 0)
            return 0;
        if(sum == 0)
            return 1;

        if(arr[n - 1] <= sum)
            return memoizedSolution(arr, n - 1, sum - arr[n - 1]) + memoizedSolution(arr, n - 1, sum);
        return memoizedSolution(arr, n - 1, sum);
    }

    int topDownDp(int[] arr, int n, int sum){
        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0; i <= sum; i++)
            dp[0][i] = 0;

        for(int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= sum; j++){
                if(arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }

        return dp[n][sum];
    }

    public static void main(String[] args){
        int[] arr = {1, 1, 1, 1};
        System.out.print(memoizedSolution(arr, 4, 1));
    }

}
