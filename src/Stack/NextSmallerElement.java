package Stack;

import java.util.Stack;

// Return an array of next smaller elements of each of the numbers in the array
public class NextSmallerElement {
    public int[] nextSmallerElements(int[] nums){
        Stack<Integer> stk = new Stack<>();
        int numsSize = nums.length;
        int[] nextSmallerElementsOfNums = new int[numsSize];

        for(int index = numsSize - 1; index >= 0; index--){
            while(!stk.isEmpty() && stk.peek() >= nums[index]){
                stk.pop();
            }

            nextSmallerElementsOfNums[index] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[index]);
        }
        return nextSmallerElementsOfNums;
    }
}
