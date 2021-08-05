package DP.Kanpsack;

// n = no: of weights/values
// w = capacity pf the knapsack
public class knapsack_0_1 {
    int[][] dp = new int[102][1002];
    int memoizedSolution(int[] wt, int[] val, int n, int w){
        if(n == 0 || w == 0)
            return 0;

        if(dp[n][w] != -1)
            return dp[n][w];

        // If weight at n - 1  is less than or equal to w, then there are two options/ choices
        if(wt[n - 1] <= w)
            // To choose the weight or to not choose the weight
            return dp[n][w] = Math.max(val[n - 1] + memoizedSolution(wt, val, n - 1, w - wt[n - 1]),
                    memoizedSolution(wt, val, n - 1, w));
        // do not choose the weight
        return dp[n][w] = memoizedSolution(wt, val, n - 1, w);
    }

    int topDownDp(int[] wt, int[] val, int n, int w){
        int[][] dp = new int[n + 1][w + 1];

        // Initialization
        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= w; j++)
                if(i == 0 || j == 0)
                    dp[i][j] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= w; j++){
                if(wt[i - 1] <= j){
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][w];
    }
}
