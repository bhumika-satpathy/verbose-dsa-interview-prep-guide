package DP.UnboundedKnapsack;

// Find minimum number of coins that make a given value
public class CoinChange2 {

    static int memoizedSolution(int[] coins, int n, int N){
        if(n == 0 && N > 0)
            return Integer.MAX_VALUE - 1;
        if(N == 0)
            return 0;

        if(coins[n - 1] <= N)
            return Math.min(1 + memoizedSolution(coins, n, N - coins[n - 1]), memoizedSolution(coins, n - 1, N));
        return memoizedSolution(coins, n - 1, N);
    }

    static int topDownDp(int[] coins, int n, int N){
        int[][] dp = new int[n + 1][N + 1];

        for(int i = 0; i <= N; i++)
            dp[0][i] = Integer.MAX_VALUE - 1;

        for(int i = 0; i <= n; i++)
            dp[i][0] = 0;

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= N; j++){
                if(coins[i - 1] <= j){
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }

        return dp[n][N];
    }

    public static void main(String[] args){
        int[] coins = {25, 10, 5};
        System.out.println(topDownDp(coins, 3, 30));
        System.out.println(memoizedSolution(coins, 3, 30));
    }

}
