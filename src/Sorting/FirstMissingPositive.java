package Sorting;

// Given an unsorted integer array nums, find the smallest missing positive integer.
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        boolean onePresent = false;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1)
                onePresent = true;
        }
        if(!onePresent)
            return 1;

        for(int i = 0; i < n; i++){
            if(nums[i] <= 0 || nums[i] > n)
                nums[i] = 1;
        }

        for(int i = 0; i < n; i++){
            int a = Math.abs(nums[i]);
            if(a == n)
                nums[0] = -nums[0];
            else if(nums[a] < 0)
                continue;
            else nums[a] = -nums[a];
        }

        for(int i = 1; i < n; i++){
            if(nums[i] > 0)
                return i;
        }

        if(nums[0] > 0)
            return n;
        return n + 1;
    }
}
