package TwoPointers;

// Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
//Return the length of the longest (contiguous) subarray that contains only 1s.

public class MaximumConsecutiveOnes {
    public int longestOnes(int[] A, int k) {
        int i = 0, j = 0;

        for(j = 0; j < A.length; j++){
            if(A[j] == 0)k--;
            if(k < 0 && A[i++] == 0)k++;
        }
        return j - i;
    }
}
