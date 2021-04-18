package TwoPointers;
import java.util.Arrays;

// Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
//A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
//0 <= i, j < nums.length
//i != j
//|nums[i] - nums[j]| == k
//Notice that |val| denotes the absolute value of val.

public class KDiffPairsInAnArray {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0, r = 0, pairs = 0;

        while(l < nums.length && r < nums.length){
            int diff = nums[r] - nums[l];
            if(l != r && diff == k){
                pairs++;
                l++;
                while(l < nums.length && nums[l] == nums[l - 1])
                    l++;
            }
            else if(diff > k)
                l++;
            else r++;
        }
        return pairs;
    }

}
