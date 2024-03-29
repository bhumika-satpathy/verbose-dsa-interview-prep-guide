package DP.Kanpsack;

// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//Now consider if some obstacles are added to the grids. How many unique paths would there be?
//An obstacle and space is marked as 1 and 0 respectively in the grid.
public class UniquePaths {
//    ----------------- Recursive ----------------------------------------------
    public int uniquePathsWithObstacles(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                dp[i][j] = -1;

        if(mat[m - 1][n - 1] == 1)
            return 0;
        if(mat.length == 1)
            return mat[0][0] == 0 ? 1 : 0;
        return uniquePaths(mat, m - 1, n - 1, dp);
    }

    int uniquePaths(int[][] mat, int m, int n, int[][] dp){
        if(m == 0 || n == 0){
            if(m > 0){
                if(mat[m - 1][n] != 1)
                    return dp[m][n] = uniquePaths(mat, m - 1, n, dp);
                return dp[m][n] = 0;
            }
            if(n > 0){
                if(mat[m][n - 1] != 1)
                    return dp[m][n] = uniquePaths(mat, m, n - 1, dp);
                return dp[m][n] = 0;
            }
            return dp[m][n] = 1;
        }

        if(dp[m][n] != -1)
            return dp[m][n];

        if(mat[m - 1][n] != 1 && mat[m][n - 1] != 1)
            return dp[m][n] = uniquePaths(mat, m - 1, n, dp) + uniquePaths(mat, m, n - 1, dp);

        if(mat[m][n - 1] != 1)
            return dp[m][n] = uniquePaths(mat, m, n - 1, dp);

        if(mat[m - 1][n] != 1)
            return dp[m][n] = uniquePaths(mat, m - 1, n, dp);
        return dp[m][n] = 0;
    }


//    ----------------------- DP -----------------------------
    /*
        1. Calculate for the base conditions, i.e., what if the origin has a rock or the end point has a rock
        2. Calculate for first row and column
    * */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];
    }
}
}
