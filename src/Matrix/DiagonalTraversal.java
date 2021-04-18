package Matrix;

public class DiagonalTraversal {
    static void diagonalTraversal(int[][] mat){

        for(int i = 0; i < mat.length; i++){
            int k = i, j = 0;
            while(k >= 0 && j <= i && j < mat[0].length)
                System.out.print(mat[k--][j++] + " ");
            System.out.println();
        }

        for(int k = 1; k < mat[0].length; k++){
            System.out.print(mat[mat.length - 1][k] + " ");

            int i = mat.length - 2;
            int j = k + 1;

            while(i >= 0 && j < mat[0].length){
                System.out.print(mat[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int M[][] = {
                { 1, 2, 3, 4 },     { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },  { 13, 14, 15, 16 },
                { 17, 18, 19, 20 },
        };
        diagonalTraversal(M);
    }
}
