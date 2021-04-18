package Matrix;

// For N X N square matrix, in-place is possible by just swapping the opposite elements.
// For a rectangular matrix, in-place is not possible
public class Transpose {

    // In-place possible
    void transposeSquareMatrix(int[][] mat){
        int N = mat.length;
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
    }

    // rectangular matrix: M X N
    void transposeRectangularMatrix(int[][] mat){
        int M = mat.length, N = mat[0].length;
        int[][] newMat = new int[N][M];

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                newMat[j][i] = mat[i][j];
            }
        }
    }
}
