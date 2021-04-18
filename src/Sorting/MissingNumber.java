package Sorting;

// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
//Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean onePresent = false;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                onePresent = true;
                break;
            }
        }

        if(!onePresent)
            return 1;

        boolean zero = false;

        for(int i = 0; i < n; i++)
            if(nums[i] == 0){
                nums[i] = 1;
                zero = true;
                break;
            }
        if(!zero)
            return 0;

        for(int i = 0; i < n; i++){
            int a = Math.abs(nums[i]);
            if(a == n){
                nums[0] = -nums[0];
                continue;
            }
            else {
                if(nums[a] < 0)
                    continue;
                nums[a] = -nums[a];
            }
        }

        for(int i = 1; i < n; i++){
            if(nums[i] > 0)
                return i;
        }
        if(nums[0] > 0)
            return n;
        return n;
    }
}
