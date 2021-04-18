package TwoPointers;

// Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
// of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
public class MinimumSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, sum = 0, ans = Integer.MAX_VALUE;

        while(l < nums.length && r < nums.length){
            if(sum < target){
                sum += nums[r++];
            }
            if(sum >= target) {
                ans = Math.min(ans, r - l);
                while(l < r && sum >= target){
                    sum -= nums[l++];
                    if(sum >= target)
                        ans = Math.min(ans, r - l);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}