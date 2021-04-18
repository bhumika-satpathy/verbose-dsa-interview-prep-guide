package Sorting;

import java.util.ArrayList;
import java.util.List;

// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
public class FindAllNumbersDissapearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int a = Math.abs(nums[i]);
            if(nums[a - 1] > 0)
                nums[a - 1] = -nums[a - 1];
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 0)
                ans.add(i + 1);
        }

        return ans;
    }
}
