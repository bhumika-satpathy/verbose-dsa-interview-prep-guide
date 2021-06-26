package BitManipulation;

// Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
//
//You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
// https://leetcode.com/problems/single-number-iii/
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        // bitmask = x ^ y
        // y = bitmask ^ x
        // x = bitmask ^ y
        for (int num : nums){
            // this step would also include those nums which occur twice but because they occur twice,
            // they would be 0 at the end, given that xor of two nums is always 0
            if ((num & diff) != 0) x ^= num;
        }

        return new int[]{x, bitmask^x};
    }
}
