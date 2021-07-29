package Arrays;

// Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
// https://leetcode.com/problems/majority-element/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int cnt = 0;

        for(int num: nums) {
            if(cnt == 0) {
                candidate = num;
            }
            cnt += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}

// Note that it is guaranteed that there is a majority element in the array so your implementation can omit the second pass.
// However, in a general case, you need this second pass since your array can have no majority elements at all!