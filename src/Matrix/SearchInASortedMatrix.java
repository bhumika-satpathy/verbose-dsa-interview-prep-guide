package Matrix;

// Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it.
// Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing order. The designed algorithm should have linear time complexity.
public class SearchInASortedMatrix {
    int findElement(int[][] mat, int x){
        int i = 0, j = mat[0].length - 1;

        while(i < mat.length && j >= 0){
            if(mat[i][j] == x){
                System.out.print(mat[i][j]);
                break;
            }
            if(mat[i][j] > x)
                i++;
            else j--;
        }
        return -1;
    }
}
