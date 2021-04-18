package Matrix;

// Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.
public class BooleanMatrix {

    void booleanMatrix(int[][] mat){
        if(mat.length == 0)
            return;

        boolean rowFlag = false;
        boolean colFlag = false;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(i == 0 && mat[i][j] == 1)
                    rowFlag = true;
                if(j == 0 && mat[i][j] == 1)
                    colFlag = true;
                if(mat[i][j] == 1){
                    mat[0][j] = 1;
                    mat[i][0] = 1;
                }
            }
        }

        for(int i = 1; i < mat.length; i++)
            for(int j = 1; j < mat[0].length; j++)
                if(mat[i][0] == 1 || mat[0][j] == 1)
                    mat[i][j] = 1;

        if(rowFlag)
            for(int i = 0; i < mat[0].length; i++)
                mat[0][i] = 1;

        if(colFlag)
            for(int i = 0; i < mat.length; i++)
                mat[i][0] = 1;
    }
}