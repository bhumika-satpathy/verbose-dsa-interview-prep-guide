package Matrix;

// Rotate a matrix by 90 degrees in-place
// Approach:
// Find transpose
// Reverse the columns
// Rotate clockwise = Transpose + reverse(cols)
// Rotate anticlockwise = Transpose + reverse(rows)
public class RotateBy90AntiClockwise {

    void transpose(int[][] mat){
        int n = mat.length;

        for(int i = 0; i < n ;i++)
            for(int j = i; j < mat[0].length; j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
    }

    void reverseColumns(int[][] mat){
        int n = mat[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0, k = mat[0].length; j < k; j++, k--){
                int tmp = mat[j][i];
                mat[j][i] = mat[k][i];
                mat[k][i] = tmp;
            }
        }
    }

    void rotateBy90(int[][] mat){

    }

}
