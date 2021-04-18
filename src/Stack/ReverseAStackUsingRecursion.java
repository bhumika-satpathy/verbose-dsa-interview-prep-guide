package Stack;

import java.util.Stack;

// Reverse a stack using recursion
public class ReverseAStackUsingRecursion {

    void reverseStack(Stack<Integer> stack, int x){
        if(stack.isEmpty())
            stack.push(x);

        else {
            int a = stack.pop();
            reverseStack(stack, x);
            stack.push(a);
        }
    }

    void Solution(Stack<Integer> stack){
        if(stack.isEmpty())
            return;

        int x = stack.pop();
        Solution(stack);
        reverseStack(stack, x);
    }
}
