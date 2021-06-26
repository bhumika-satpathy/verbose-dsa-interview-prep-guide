package BinarySearch;

import java.util.List;

// (This problem is an interactive problem.)
//
//A row-sorted binary matrix means that all elements are 0 or 1 and each row of the matrix is sorted in non-decreasing order.
//
//Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed) of the leftmost column with a 1 in it. If such an index does not exist, return -1.
//
//You can't access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:
//
//BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
//BinaryMatrix.dimensions() returns the dimensions of the matrix as a list of 2 elements [rows, cols], which means the matrix is rows x cols.
//Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.
//
//For custom testing purposes, the input will be the entire binary matrix mat. You will not have access to the binary matrix directly.
// https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
public class LeftmostColumnWithAtleastAOne {
    interface BinaryMatrix {
      public int get(int row, int col);
      public List<Integer> dimensions();
  };
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0), cols = binaryMatrix.dimensions().get(1);
        int ans = cols;

        for(int i = 0; i < rows; i++) {
            int l = 0;
            int h = cols - 1;

            while(l < h) {
                int m = (l + h) / 2;
                if(binaryMatrix.get(i, m) == 0) {
                    l = m + 1;
                } else {
                    h = m;
                }
            }
            if(binaryMatrix.get(i, l) == 1) {
                ans = Math.min(ans, l);
            }
        }

        return ans == cols ? -1 : ans;
    }
}
