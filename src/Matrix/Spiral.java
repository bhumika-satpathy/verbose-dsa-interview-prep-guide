package Matrix;

// Print the matrix in spiral form
public class Spiral {
    void printSpiral(int[][] mat, int m, int n){
        // m = no: of rows
        // n = no: of columns
        // k = start of the row
        // l = start of the column
        // m, n = end points of the row and the column respectively

        int k = 0, l = 0;

        while(k < m && l < n){
            for(int i = l; i < n; i++){
                System.out.print(mat[k][i] + " ");
            }
            k++;

            for(int i = k; i < m; i++)
                System.out.print(mat[i][n - 1]);
            n--;

            if(k < m){
                for(int i = n - 1; i >= l; i--)
                    System.out.print(mat[m - 1][i]);
                m--;
            }

            if(l < n){
                for(int i = m - 1; i >= k; i--)
                    System.out.print(mat[i][l]);
                l++;
            }
        }
    }
}
