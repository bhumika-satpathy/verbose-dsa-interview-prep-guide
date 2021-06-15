package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            // If the number is greater than 0, then all its corresponding pairs would also be and hence they would never sum upto 0
            if(nums[i] > 0) {
                break;
            }
            // nums[i] != nums[i - 1] because we don't want repetitive pairs and if they are equal, then pairs are bound to be repetitive as per the algorithm
            if(i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    void twoSum(int[] nums, int startIndex, List<List<Integer>> res) {
        int left = startIndex + 1, right = nums.length - 1;
        while(left < right) {
            if(nums[startIndex] + nums[left] + nums[right] < 0) {
                left++;
            } else if(nums[startIndex] + nums[left] + nums[right] > 0) {
                right--;
            } else {
                res.add(Arrays.asList(nums[startIndex], nums[left++], nums[right--]));
                while(left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }
}
