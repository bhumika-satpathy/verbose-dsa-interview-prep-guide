package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

// Check for balanced brackets in an expression
public class CheckForBalancedBrackets {
    boolean Solution(String exp){
        // Dequeue is faster than stack
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '(' || exp.charAt(i) == '{' || exp.charAt(i) == '[')
                stack.push(exp.charAt(i));
            else {
                char ch = stack.pop();
                if(ch == '(' && (exp.charAt(i) == '}' || exp.charAt(i) == ']'))
                    return false;
                if(ch == '{' && (exp.charAt(i) == ')' || exp.charAt(i) == ']'))
                    return false;
                if(ch == '[' && (exp.charAt(i) == '}' || exp.charAt(i) == ')'))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
