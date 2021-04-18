package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                break;
            if(i == 0 || nums[i] != nums[i - 1])
                twoSum(nums, i, res);
        }

        return res;
    }

    void twoSum(int[] nums, int startIndex, List<List<Integer>> res){
        int l = startIndex + 1, r = nums.length - 1;
        while(l < r){
            if(nums[startIndex] + nums[l] + nums[r] < 0)
                l++;
            else if(nums[startIndex] + nums[l] + nums[r] > 0)
                r--;
            else {
                res.add(Arrays.asList(nums[startIndex], nums[l++], nums[r--]));
                while(l < r && nums[l] == nums[l - 1])
                    l++;
            }
        }
    }
}
