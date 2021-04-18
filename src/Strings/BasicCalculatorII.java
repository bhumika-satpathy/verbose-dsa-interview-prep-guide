package Strings;

import java.util.Stack;

// Given a string s which represents an expression, evaluate this expression and return its value.
//
//The integer division should truncate toward zero.
public class BasicCalculatorII {
    public int calculate(String s) {
        if(s.length() == 0 || s == null)
            return 0;

        Stack<Integer> stk = new Stack<>();
        char operation = '+';
        int currNum = 0;

        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)){
                currNum = currNum * 10 + (currChar - '0');
            }
            if((!Character.isDigit(currChar) && !Character.isWhitespace(currChar)) || i == s.length() - 1){
                if(operation == '+')
                    stk.push(currNum);
                else if(operation == '-')
                    stk.push(-currNum);
                else if(operation == '*')
                    stk.push(currNum * stk.pop());
                else
                    stk.push(stk.pop() / currNum);
                operation = currChar;
                currNum = 0;
            }
        }

        int ans = 0;
        while(!stk.isEmpty()){
            ans += stk.pop();
        }
        return ans;
    }
}
