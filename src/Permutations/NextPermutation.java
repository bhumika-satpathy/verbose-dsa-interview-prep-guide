package Permutations;
// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
//
//The replacement must be in place and use only constant extra memory.
// https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // Traverse from the end till the point where ascending ordering starts.
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if(i >= 0) {
            int j = nums.length - 1;
            while(nums[i] >= nums[j]) {
                j--;
            }

            swap(nums, i, j);
        }

        // Upto i + 1 above, we found the elements were in decreasing order, hence
        // To find the next greater, we put the next greater in the ith place and from i + 1 reverse so that the elements are in the decreasing order
        reverse(nums, i + 1);
    }

    void swap(int[] nums, int startIndex, int endIndex) {
        int tmp = nums[startIndex];
        nums[startIndex] = nums[endIndex];
        nums[endIndex] = tmp;
    }

    void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
