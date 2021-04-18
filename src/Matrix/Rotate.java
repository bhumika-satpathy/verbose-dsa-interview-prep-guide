package Matrix;

// Rotate a matrix
public class Rotate {

    void rotateMatrix(int[][] mat){
        // row: Starting row index
        // m: Ending row index
        // col: starting col index
        // n: ending col index
        int row = 0, col = 0, m = mat.length, n = mat[0].length;

        while(row < m && col < n){
            if(row == m - 1 || col == n - 1)
                break;

            int prev = mat[row + 1][col], curr;

            for(int i = col; i < n; i++){
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;

            for(int i = row; i < m; i++){
                curr = mat[i][n - 1];
                mat[i][n - 1] = prev;
                prev = curr;
            }
            n--;

            if(row < m){
                for(int i = n - 1; i >= col; i--){
                    curr = mat[m - 1][i];
                    mat[m - 1][i] = prev;
                    prev = curr;
                }
                m--;
            }
            if(col < n){
                for(int i = m - 1; i >= row; i--){
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
                col++;
            }
        }
    }

}
