package Stack;

import java.util.Stack;

// Operands sit inside the stack
public class PostfixToInfix {
    boolean isOperand(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >='A' && ch <= 'Z');
    }

    String Solution(String exp){
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(isOperand(ch))
                stack.push(ch + "");
            else {
                String op1 = stack.pop();
                String op2 = stack.pop();

                stack.push("(" + op2 + exp.charAt(i) + op1 + ")");
            }
        }

        return stack.pop();
    }
}
