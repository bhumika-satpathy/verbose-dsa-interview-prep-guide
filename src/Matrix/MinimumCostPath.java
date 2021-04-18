package Matrix;

// Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
// Each cell of the matrix represents a cost to traverse through that cell. The total cost of a path to reach (m, n) is the sum of all the costs on that path (including both source and destination).
// You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1), and (i+1, j+1) can be traversed.
// You may assume that all costs are positive integers.
public class MinimumCostPath {
    int minimumCostPath(int[][] mat, int m, int n){

        for(int i = 1; i < mat[0].length; i++){
            mat[0][i] += mat[0][i - 1];
        }

        for(int i = 1; i < mat.length; i++){
            mat[i][0] += mat[i - 1][0];
        }

        for(int i = 1; i < mat.length; i++){
            for(int j = 1; j < mat[0].length; j++){
                mat[i][j] += Math.min(mat[i][j - 1], Math.min(mat[i - 1][j - 1], mat[i - 1][j]));
            }
        }

        return mat[m][n];
    }
}
