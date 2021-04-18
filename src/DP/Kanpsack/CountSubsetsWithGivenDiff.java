package DP.Kanpsack;

// Count no of subsets with given difference
// Approach s1 - s2 = diff => Given
// s1 + s2 = sum => s1 = (sum + diff)/2
// Equivalent to count number of subsets with given sum
public class CountSubsetsWithGivenDiff {

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
                    dp[i][j] |= dp[i][j - arr[i - 1]];
            }
        }

        return dp[n][sum];
    }

}
