package Matrix;

import java.util.HashSet;

// Print unique rows in a matrix
// Could also be solved using BST since BST doesn't contain duplicates. O(row * col + row * log(col))
// Using hashset: O(row * col)
public class PrintUniqueRows {

    String getStr(int[] arr){
        String res = "";
        for(int i = 0; i < arr.length; i++)
            res += String.valueOf(arr[i]);

        return res;
    }

    void printUniqeRows(int[][] mat){
        if(mat.length == 0 || mat.length == 1)
            return;

        HashSet<String> map = new HashSet<>();
        for(int i = 0; i < mat.length; i++){
            String res = getStr(mat[i]);
            if(!map.contains(res)){
                for(int j = 0; j < mat[0].length; j++)
                    System.out.print(mat[i][j] + " ");
                System.out.println();
            }
        }
    }

}
