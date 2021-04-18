package Stack;

import java.util.Stack;

// Find maximum depth of nested parenthesis in a string. (((((()))))
public class MaximumDepthOfNestedParenthesis {
    int Solution1(String str){
        Stack<Character> stack = new Stack<>();
        int max = 0, cnt = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push(str.charAt(i));
                cnt++;

                if(cnt > max)
                    max = cnt;
            } else if(str.charAt(i) == ')'){
                if(stack.isEmpty())
                    return -1;
                stack.pop();
                cnt--;
            }
        }

        if(!stack.isEmpty())
            return -1;
        return max;
    }

    int Solution2(String str){
        int max = 0, cnt = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                cnt++;
                max = max > cnt ? cnt : cnt;
            } else if(str.charAt(i) == ')') {
                if(cnt < 0)
                    return -1;
                cnt--;
            }
        }

        return cnt != 0 ? -1 : max;
    }
}
