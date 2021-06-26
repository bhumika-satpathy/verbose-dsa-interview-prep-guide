package Greedy;

// Given an array nums, partition it into two (contiguous) subarrays left and right so that:
//
//Every element in left is less than or equal to every element in right.
//left and right are non-empty.
//left has the smallest possible size.
//Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
// https://leetcode.com/problems/partition-array-into-disjoint-intervals/
public class PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] maxLeft = new int[nums.length];
        int[] minRight = new int[nums.length];

        maxLeft[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }

        minRight[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }

        for(int i = 1; i < nums.length; i++) {
            if(maxLeft[i - 1] <= minRight[i]) {
                return i;
            }
        }
        return -1;
    }
}
