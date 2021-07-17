package Arrays;

// Given an array of integers nums, calculate the pivot index of this array.
//
//The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
//
//If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
//
//Return the leftmost pivot index. If no such index exists, return -1.
// https://leetcode.com/problems/find-pivot-index/
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int num: nums) {
            sum += num;
        }

        int lSum = 0;
        for(int i = 0; i < n; i++) {
            if(lSum == sum - lSum - nums[i]) {
                return i;
            }
            lSum += nums[i];
        }

        return -1;
    }
}
