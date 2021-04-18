package Stack;

import java.util.Stack;

public class SortAStackUsingATemporaryStack {
    Stack<Integer> Solution(Stack<Integer> stack){
        Stack<Integer> tmpStack = new Stack<>();

        while(!stack.isEmpty()){
            int x = stack.pop();

            while(!tmpStack.isEmpty() && tmpStack.peek() > x)
                stack.push(tmpStack.pop());
            tmpStack.push(x);
        }

        return tmpStack;
    }
}
