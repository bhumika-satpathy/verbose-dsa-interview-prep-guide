package BinarySearch;

import java.util.Arrays;

public class TwoElementsWithSumClosestTo0 {

    int[] Solution(int[] arr, int low, int high){
        Arrays.sort(arr);
        int minSum = Integer.MAX_VALUE;
        int i = 0, j = arr.length - 1;
        int sum = 0;

        while(low <= high){
            sum = arr[low] + arr[high];
            if(Math.abs(sum) < Math.abs(minSum)){
                minSum = sum;
                i = low;
                j = high;
            } else if(sum > 0)
                high--;
            else low++;
        }

        return new int[]{i, j};
    }

}
