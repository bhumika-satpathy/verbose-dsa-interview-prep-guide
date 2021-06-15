package TwoPointers;

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.

// Note: It is in fact evident enough that the distance between i and lastZeroAt is filled with zeroes because of which the swapping works. Analyze always while solving
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int lastZeroAt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, lastZeroAt++);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
