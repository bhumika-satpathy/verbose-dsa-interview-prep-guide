package TwoPointers;
import java.util.Arrays;

// Given an array of n integers nums and an integer target,
// find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int pairs = 0;

        for(int i = 0; i < nums.length - 2; i++){
            int l = i + 1, r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < target){
                    pairs += r - l;
                    l++;
                } else
                    r--;
            }
        }
        return pairs;
    }
}
