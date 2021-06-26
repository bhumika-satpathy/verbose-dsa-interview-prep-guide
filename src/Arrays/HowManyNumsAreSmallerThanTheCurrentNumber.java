package Arrays;

// Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
//
//Return the answer in an array.
// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
public class HowManyNumsAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        // Count the number of elements that are less than or equal to i, inclusive
        for(int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                ans[i] = 0;
            } else {
                ans[i] = count[nums[i] - 1];
            }
        }

        return ans;
    }
}
