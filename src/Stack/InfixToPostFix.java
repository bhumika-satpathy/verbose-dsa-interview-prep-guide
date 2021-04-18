package Stack;

import java.util.Stack;

// The operator and the parenthesis sit inside the stack
public class InfixToPostFix {
    static int Precedence(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    String Solution(String exp){
        char ch;
        String res = "";
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            ch = exp.charAt(i);

            if(ch == '(')
                stack.push(ch);

            else if(Character.isLetterOrDigit(ch))
                res += ch;

            else if(ch == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    res += stack.pop();
                }
                stack.pop();
            }

            else {
                while(!stack.isEmpty() && Precedence(ch) <= Precedence(stack.peek()))
                    res += stack.pop();
                stack.push(ch);
            }

        }

        while(!stack.isEmpty()){
            if(stack.peek() == '(')
                System.out.println("Invalid Expression!");
            res += stack.pop();
        }
        return res;
    }
}
