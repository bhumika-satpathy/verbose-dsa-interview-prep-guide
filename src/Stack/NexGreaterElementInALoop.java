package Stack;

import java.util.Stack;

// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
//
//The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
public class NexGreaterElementInALoop {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stk = new Stack<>();

        for(int i = 2 * nums.length - 1; i >= 0; i--){
            while(!stk.isEmpty() && nums[stk.peek()] <= nums[i % nums.length]){
                stk.pop();
            }
            res[i % nums.length] = stk.isEmpty() ? -1 : nums[stk.peek()];
            stk.push(i % nums.length);
        }
        return res;
    }
}
