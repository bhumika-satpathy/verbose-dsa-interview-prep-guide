package Stack;

import java.util.Stack;

// Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
//For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
//Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[T.length];
        for(int i = T.length - 1; i >= 0; i--){
            while(!stk.isEmpty() && T[stk.peek()] <= T[i])
                stk.pop();
            ans[i] = stk.isEmpty() ? 0 : stk.peek() - i;
            stk.push(i);
        }
        return ans;
    }
}
