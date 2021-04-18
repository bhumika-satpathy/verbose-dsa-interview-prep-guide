package Stack;

import java.util.Stack;

// Sort a stack using recursion
public class SortAStackUsingRecursion {

    void sortStack(Stack<Integer> stack, int x){
        if(stack.isEmpty() || stack.peek() <= x)
            stack.push(x);
        else {
            int a = stack.pop();
            sortStack(stack, x);
            stack.push(a);
        }
    }

    void Solution(Stack<Integer> stack){
        if(stack.isEmpty())
            return;

        int x = stack.pop();
        Solution(stack);
        sortStack(stack, x);
    }
}
