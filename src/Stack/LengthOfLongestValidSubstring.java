package Stack;

import java.util.Stack;
/*
Basic logic is that we initialize the stack with -1 as the initial value in the bucket. Now, whenever there is an extra closing bracket without an opening bracket, -1 is popped out and the lengths of
valid strings eventually keep changing.
 */
public class LengthOfLongestValidSubstring {
    int Solution(String str){
        int res = 0;
        Stack<Integer>stack = new Stack<>();
        stack.push(-1);

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(')
                stack.push(i);

            else {
                if(!stack.isEmpty())
                    stack.pop();

                if(!stack.isEmpty())
                    res = Math.max(res, i - stack.peek());
                else stack.push(i);
            }
        }

        return res;
    }
}
