package BinarySearch;

import java.util.Arrays;

public class MedianOf2SortedArrays {

    static float M02(int a, int b) {
        return (float) ((a + b) / 2.0);
    }

    // A utility function to find median of three integers
    static float M03(int a, int b, int c) {
        return a + b + c - Math.max(a, Math.max(b, c)) -
                Math.min(a, Math.min(b, c));
    }

    // A utility function to find a median of four integers
    static float M04(int a, int b, int c, int d) {
        int Max = Math.max(a, Math.max(b, Math.max(c, d)));
        int Min = Math.min(a, Math.min(b, Math.min(c, d)));
        return (float) ((a + b + c + d - Max - Min) / 2.0);
    }

    // Utility function to find median of single array
    static float M01(int arr[], int n) {
        if (n == 0)
            return -1;
        if (n % 2 == 0)
            return (float) ((double) (arr[n / 2] +
                    arr[n / 2 - 1]) / 2);
        return arr[n / 2];
    }

    float findMedian(int[] arr1, int m, int[] arr2, int n){
        if(m == 0)
            return M01(arr2, n);

        if(m == 1){
            // if n == 1
            if(n == 1)
                return M02(arr1[0], arr2[0]);

            // if n % 2 == 1
            if(n % 2 == 1)
//                return M02(arr2[n/2], (float)M03(arr1[0], arr2[n/2 - 1], arr2[n/2 + 1]));

            // if n % 2 == 0
            return M03(arr2[n/2], arr1[0], arr2[n/2 - 1]);
        }

        else if(m == 2){
            // if n == 2
            if(n == 2)
                return M04(arr1[0], arr1[1], arr2[0], arr2[1]);

            // if n % 2 == 1
            if(n % 2 ==1)
                return M03(arr2[n/2], Math.max(arr1[0], arr2[n/2 - 1]), Math.min(arr1[1], arr2[n/2 + 1]));

            // if n % 2 == 0
            return M04(arr2[n/2], arr2[n/2 - 1], Math.max(arr1[0], arr2[n/2 - 2]), Math.min(arr1[1], arr2[n/2 + 1]));
        }

        int iArr1 = (m - 1)/2, iArr2 = (n - 1)/2;

        if(arr1[iArr1] <= arr2[iArr2])
            return findMedian(Arrays.copyOfRange(arr1, iArr1, arr1.length), m/2 + 1, arr2, n - iArr2);
        return findMedian(arr1, m/2 + 1, Arrays.copyOfRange(arr2, iArr2, arr2.length), n - iArr2);
    }

}
