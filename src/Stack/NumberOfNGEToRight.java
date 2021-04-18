package Stack;

import java.util.Stack;

// Number of next greater elements to the right
public class NumberOfNGEToRight {
    int Solution(int[] arr, int index){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--){
            int curr = arr[i];

            while(!stack.isEmpty() && arr[stack.peek()] <= curr){
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int[] dp = new int[arr.length];
        for(int i = arr.length - 2; i >= 0; i--){
            if(res[i] == -1)
                dp[i] = 0;
            else dp[i] = 1 + dp[res[i]];
        }
        return dp[index];
    }
}
