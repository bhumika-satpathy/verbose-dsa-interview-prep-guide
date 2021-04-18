package TwoPointers;
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k;

        for(k = m + n - 1; k >= 0; k--){
            if(j < 0)
                break;
            if(i >= 0 && nums1[i] > nums2[j])
                nums1[k] = nums1[i--];
            else nums1[k] = nums2[j--];
        }
    }
}
