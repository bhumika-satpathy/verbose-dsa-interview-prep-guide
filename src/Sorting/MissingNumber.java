package Sorting;

// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
//Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
public class MissingNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            boolean isOne = false;
            boolean isZero = false;

            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 1) {
                    isOne = true;
                }
                if(nums[i] == 0) {
                    nums[i] = 1;
                    isZero = true;
                }
            }

            if(!isOne || !isZero) {
                return !isOne ? 1 : 0;
            }

            int n = nums.length;

            for(int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);

                if(num == n) {
                    nums[0] = -1;
                    continue;
                }
                if(num != 0 && num != 1)
                    nums[num] = -nums[num];
            }

            for(int i = 2; i < n; i++) {
                if(nums[i] > 0) {
                    return i;
                }
            }

            return n;
        }
    }
}
