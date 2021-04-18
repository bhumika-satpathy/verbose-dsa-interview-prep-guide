package Matrix;

// Find row with maximum number of ones
public class RowWithMaxOnes {// [0 0 0 1 1]

    int findFirstOne(int[] arr){
        int l = 0, r = arr.length - 1;

        while(l < r){
            int mid = (l + r)/2;
            if(arr[mid] == 1 && arr[mid - 1] != 1)
                return mid;
            if(arr[mid] == 1)
                r = mid;
            else l = mid + 1;
        }
        return -1;
    }

    int maxOnes(int[][] mat){
        // Column index with leftmost 1
        int j = findFirstOne(mat[0]), i = 1;
        int row = mat.length, maxRow = 0;

        // In case the first row has 0 1s
        if(j == -1)
            j = mat[0].length - 1;

        for(i = 1; i < row; i++){
            while(j >= 0 && mat[i][j] == 1){
                j = j - 1;
                maxRow = i;
            }
        }
        return maxRow;
    }
}
