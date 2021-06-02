package DP.Kanpsack;

// You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
//Find out how many ways to assign symbols to make sum of integers equal to target S.
// Approach: This problem is same as count no of subsets with given diff except for the fact that here the diff is always supposed to be 1
public class TargetSum {

    int[][] dp = new int[1002][1002];
    int countSubsetsWithGivenSum(int[] arr, int n, int sum){
        if(n == 0 && sum > 0)
            return 0;

        if(sum == 0)
            return 1;

        if(dp[n][sum]!= -1)
            return dp[n][sum];

        if(arr[n - 1] <= sum)
            return countSubsetsWithGivenSum(arr, n - 1, sum - arr[n - 1]) + countSubsetsWithGivenSum(arr, n - 1, sum);
        return countSubsetsWithGivenSum(arr, n - 1, sum);
    }

    int getNoOfSubsetsWithGivenSum(int[] arr, int n, int diff){
        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += arr[i];

        return countSubsetsWithGivenSum(arr, n, (sum + diff)/2);
    }


    // ------------- Top Down DP ----------------
    int topDownDp(int[] arr, int n, int diff){
        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += arr[i];

        int[][] dp = new int[n + 1][(sum + diff)/2 + 1];
        sum = (sum + diff)/2;

        for(int i = 0; i <= sum; i++)
            dp[0][i] = 0;

        for(int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                dp[i][j] = dp[i][j - 1];
                if(arr[i - 1] <= j)
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
            }
        }

        return dp[n][sum];
    }

}
