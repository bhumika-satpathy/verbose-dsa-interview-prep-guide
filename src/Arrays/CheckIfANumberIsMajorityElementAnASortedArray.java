package Arrays;

// Given an array nums sorted in non-decreasing order, and a number target, return True if and only if target is a majority element.
//
//A majority element is an element that appears more than N/2 times in an array of length N.
// https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
public class CheckIfANumberIsMajorityElementAnASortedArray {
    public boolean isMajorityElement(int[] nums, int target) {
        int prev = 0, next = 1, cnt = 0, found = 0;
        int n = nums.length;

        while(next < n) {
            cnt = 0;
            while(next < n && nums[prev] == nums[next]) {
                prev++;
                next++;
                cnt++;
            }

            if(cnt >= n / 2) {
                found = nums[prev];
                return target == found;
            }

            prev++;
            next++;
        }

        return found == target;
    }
}
