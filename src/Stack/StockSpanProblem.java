package Stack;

// Return number consecutive stock prices less than or equal to current stock price
// Approach: Next Greater Element to the left concept

import java.util.Stack;

public class StockSpanProblem {
    int[] Solution(int[] arr){
        if(arr.length == 0)
            return null;

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int curr = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] < curr)
                stack.pop();
            res[i] = stack.isEmpty() ? 1 : i - stack.peek();
            stack.push(i);
        }

        return res;
    }
}
