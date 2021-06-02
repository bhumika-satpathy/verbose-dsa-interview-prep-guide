package Stack;

import java.util.Stack;

public class MinimumNumberOfBracketReversalsToMakeExpBalanced {
    // Time Complex: O(n)
    // Space Complex: O(n)
    int Solution1(String exp){

        if(exp.length() % 2 != 0)
            return -1;

        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '{')
                stk.push(exp.charAt(i));
            else {
                if(stk.peek() == '{')
                    stk.pop();
                else stk.push(exp.charAt(i));
            }
        }

        int left_brace = 0, right_brace = 0;
        while(!stk.isEmpty()){
            if(stk.pop() == '{')
                left_brace++;
            else right_brace++;
        }

        return (int)Math.ceil(left_brace)/2 + right_brace/2;
    }

    // Reduces space complex: O(1)
    // Time complex: O(n)
    int Solution2(String exp){

        if(exp.length() % 2 != 0)
            return -1;

        int unbalanced_left_brace = 0, right_brace = 0;
        for(int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '{')
                unbalanced_left_brace++;
            else {
                if(unbalanced_left_brace > 0)
                    unbalanced_left_brace--;
                else right_brace++;
            }
        }

        return (int)(Math.ceil(unbalanced_left_brace/2 + right_brace/2));
    }
}
