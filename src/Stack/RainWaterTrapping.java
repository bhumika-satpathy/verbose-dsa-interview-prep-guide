package Stack;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */

import java.util.Stack;

public class RainWaterTrapping {
    public int trap(int[] height) {
        Stack<Integer> stk = new Stack<>();
        int curr = 0, dist = 0, boundedHeight = 0, area = 0;

        while(curr < height.length) {
            while(!stk.isEmpty() && height[curr] > height[stk.peek()]) {
                int ele = height[stk.pop()];
                if(stk.isEmpty()) {
                    break;
                }
                dist = curr - stk.peek() - 1;
                boundedHeight = Math.min(height[curr], height[stk.peek()]) - ele;
                area += dist * boundedHeight;
            }
            stk.push(curr++);
        }
        return area;
    }
}
