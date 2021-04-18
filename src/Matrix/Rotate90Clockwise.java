package Matrix;

public class Rotate90Clockwise {

    void transpose(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = i; j < mat.length; j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
    }

    void reverseCols(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length/2; j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[i][mat.length - j - 1];
                mat[i][mat.length - j - 1] = tmp;
            }
        }
    }

    public void rotate(int[][] mat) {
        transpose(mat);
        reverseCols(mat);
    }
}
