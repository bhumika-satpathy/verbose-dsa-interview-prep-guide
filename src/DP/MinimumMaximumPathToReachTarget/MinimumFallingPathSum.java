package DP.MinimumMaximumPathToReachTarget;

// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
//A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
// Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;

        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j < n; j++){
                int x = mat[i + 1][j];
                if(j > 0)
                    x = Math.min(mat[i + 1][j - 1], x);
                if(j + 1 < n)
                    x = Math.min(x, mat[i + 1][j + 1]);
                mat[i][j] += x;
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int a: mat[0])
            ans = Math.min(ans, a);
        return ans;
    }
}
