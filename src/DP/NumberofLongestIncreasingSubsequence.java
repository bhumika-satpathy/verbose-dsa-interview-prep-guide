package DP;

// Given an integer array nums, return the number of longest increasing subsequences.
//
//Notice that the sequence has to be strictly increasing.
// https://leetcode.com/problems/number-of-longest-increasing-subsequence/
public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1;
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    // When there is an already existing sequence of size just one greater than that of len[j]: meaning one subsequence of 'same length' already exists
                    if(len[i] == len[j] + 1){
                        cnt[i] += cnt[j];
                    }
                    if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max_len == len[i])res += cnt[i];
            if(max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
