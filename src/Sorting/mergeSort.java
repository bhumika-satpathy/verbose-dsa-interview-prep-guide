package Sorting;

public class mergeSort {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        return nums;
    }

    void mergeSort(int[] nums, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    void merge(int[] nums, int start, int mid, int end) {
        int left = start, right = mid + 1;
        int[] buffer = new int[end - start + 1];
        int i = 0;

        while(left <= mid && right <= end) {
            if(nums[left] <= nums[right]) {
                buffer[i++] = nums[left];
                left++;
            } else {
                buffer[i++] = nums[right];
                right++;
            }
        }

        while(left <= mid) {
            buffer[i++] = nums[left++];
        }

        while(right <= end) {
            buffer[i++] = nums[right++];
        }

        for(int j = start; j <= end; j++) {
            nums[j] = buffer[j - start];
        }
    }
}
