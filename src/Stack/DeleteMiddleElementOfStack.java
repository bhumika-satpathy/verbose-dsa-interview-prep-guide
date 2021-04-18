package Stack;

import java.util.Stack;

public class DeleteMiddleElementOfStack {

    void deleteMiddleElement(Stack<Integer> stack, int cnt, int n){
        if(stack.isEmpty() || cnt == n)
            return;
        int a = stack.pop();
        deleteMiddleElement(stack, cnt + 1, n);
        if(cnt != n/2)
            stack.push(a);
    }

    void Solution(Stack<Integer> stack){
        deleteMiddleElement(stack, 0, stack.size());
    }
}
