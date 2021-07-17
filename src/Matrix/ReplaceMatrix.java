package Matrix;

// In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
//
//You are given an m x n matrix mat and two integers r and c representing the row number and column number of the wanted reshaped matrix.
//
//The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
//
//If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
// https://leetcode.com/problems/reshape-the-matrix/
public class ReplaceMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if(r * c != m * n || mat.length == 0) {
            return mat;
        }

        int rows = 0, cols = 0;
        int[][] res = new int[r][c];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res[rows][cols++] = mat[i][j];

                if(cols == c) {
                    cols = 0;
                    rows++;
                }
            }
        }
        return res;
    }
}
