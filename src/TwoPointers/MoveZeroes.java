package TwoPointers;

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//Note that you must do this in-place without making a copy of the array.
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int lastNonZero = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                swap(nums, i, lastNonZero++);
            }
        }
    }
    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
