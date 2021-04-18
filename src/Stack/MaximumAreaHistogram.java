package Stack;

/*
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars.
For simplicity, assume that all bars have same width and the width is 1 unit.
 */

// Approach: To find the max area, the bars to the left and right should always be greater than the current element to find its confined area.
// Find the Nearest Smaller Element towards the left and right respectively and find the area enclosed for the current element/height.

import java.util.Stack;

public class MaximumAreaHistogram {

    int[] nearestSmallerToLeft(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }

    int[] nearestSmallerToRight(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return res;
    }

    int Solution(int[] heights){
        if(heights.length == 0)
            return 0;

        int maxArea = 0;
        int[] nearestSmallerLeft = nearestSmallerToLeft(heights);
        int[] nearestSmallerRight = nearestSmallerToRight(heights);

        for(int i = 0; i < heights.length; i++){
            int l = 0, r = 0;
            if(nearestSmallerLeft[i] == -1)
                l = -1;
            if(nearestSmallerRight[i] == -1)
                r = -1;
            if(l == -1 && r == -1)
                maxArea = Math.max(maxArea, heights[i] * heights.length);
            else {
                if(l == -1)
                    maxArea = Math.max(maxArea, heights[i] * nearestSmallerRight[i]);
                else if(r == -1)
                    maxArea = Math.max(maxArea, heights[i] * (heights.length - nearestSmallerLeft[i] - 1));
                else maxArea = Math.max(maxArea, heights[i] * (nearestSmallerRight[i] - nearestSmallerLeft[i] - 1));
            }
        }

        return maxArea;
    }
}
