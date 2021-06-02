package Stack;

import java.util.Stack;

// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
public class MaximalRectangle {
    public int maxAreaHistogram(int[] heights){
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){
            int ele = heights[i];

            while(stk.peek() != -1 && heights[stk.peek()] >= ele){
                maxArea = Math.max(maxArea, heights[stk.pop()] * (i - stk.peek() - 1));
            }
            stk.push(i);
        }

        while(stk.peek() != -1){
            maxArea = Math.max(maxArea, heights[stk.pop()] * (heights.length - stk.peek() - 1));
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }

        int maxArea = 0;
        int[] dp = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    dp[j] = dp[j] + 1;
                } else {
                    dp[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, maxAreaHistogram(dp));
        }
        return maxArea;
    }
}
