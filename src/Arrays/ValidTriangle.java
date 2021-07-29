package Arrays;
import java.util.Arrays;

// Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
// Time: O(n2)
// https://leetcode.com/problems/valid-triangle-number/
public class ValidTriangle {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }
}

// This is where amortized analysis comes to play.
//For any i, we can see j walks from i to end, k walks from i+1 to end. That means j and k will walk at most n steps, respectively. Note that j, k only walk forward.
//So, there are O(n) is, and for every i, j, k needs O(n) time. Thus yields a total O(n^2) time.
