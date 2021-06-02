package Stack;

import java.util.Stack;

// Given a balanced parentheses string s, compute the score of the string based on the following rule:
//
//() has score 1
//AB has score A + B, where A and B are balanced parentheses strings.
//(A) has score 2 * A, where A is a balanced parentheses string.
//
public class ScoreOfParenthesis {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
}
