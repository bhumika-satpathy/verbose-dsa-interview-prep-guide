package Stack;

import java.util.Stack;

// Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int i = 0;

        for(int num: pushed){
            stk.push(num);

            while(!stk.isEmpty() && i < pushed.length && stk.peek() == popped[i]){
                stk.pop();
                i++;
            }
        }

        return stk.isEmpty();
    }
}
