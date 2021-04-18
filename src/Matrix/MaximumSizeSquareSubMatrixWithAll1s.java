package Matrix;

// Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
public class MaximumSizeSquareSubMatrixWithAll1s {
    void printMaxSubSquare(int[][] mat){
        int R = mat.length, C = mat[0].length;
        int[][] S = new int[R][C];

        for(int i = 0; i < C; i++)
            S[0][i] = mat[0][i];

        for(int i = 0; i < R; i++)
            S[i][0] = mat[i][0];

        int max = 0;

        for(int i = 1; i < R; i++){
            for(int j = 1; j < C; j++){
                if(mat[i][j] == 1){
                    S[i][j] = 1 + Math.max(S[i][j - 1], Math.max(S[i - 1][j], S[i - 1][j - 1]));
                    max = Math.max(max, S[i][j]);
                } else S[i][j] = 0;
            }
        }

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.print(S[i][j] + " ");
            }
            System.out.println();
        }
    }
}
