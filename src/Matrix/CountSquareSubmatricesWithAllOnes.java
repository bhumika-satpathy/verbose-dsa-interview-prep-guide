package Matrix;

public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int ans = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1 && i > 0 && j > 0) {
                    int minSquares = Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1]));
                    matrix[i][j] += minSquares;
                }
                ans += matrix[i][j];
            }
        }

        return ans;
    }
}
