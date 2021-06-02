package DP.MinimumMaximumPathToReachTarget;

import java.util.HashMap;

// Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.
//
//An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
public class ContinuosSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length == 1) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0, rem = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            rem = sum % k;

            if(rem < 0) {
                rem = rem + k;
            }

            if(map.containsKey(rem)) {
                if(i - map.get(rem) > 1){
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }
}
