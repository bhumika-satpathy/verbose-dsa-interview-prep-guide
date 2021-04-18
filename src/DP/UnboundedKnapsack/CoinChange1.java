package DP.UnboundedKnapsack;

// Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many max ways can we make the change? The order of coins doesn’t matter.
//For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6},
// there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

public class CoinChange1 {

    static int memoizedSolution(int[] coins, int n, int N){
        if(n == 0 && N > 0)
            return 0;
        if(N == 0)
            return 1;

        if(coins[n - 1] <= N)
            return memoizedSolution(coins, n, N - coins[n - 1]) + memoizedSolution(coins, n - 1, N);
        return memoizedSolution(coins, n - 1, N);
    }

    static int topDownDp(int[] coins, int n, int N){
        int[][] dp = new int[n + 1][N + 1];

        for(int i = 0; i <= N; i++)
            dp[0][i] = 0;
        for(int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= N; j++){
                if(coins[i - 1] <= j)
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][N];
    }

    public static void main(String[] args){
        int[] coins = {2, 5, 3, 6};
        System.out.println(memoizedSolution(coins, 4, 10));
    }

}
