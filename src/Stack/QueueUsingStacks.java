package Stack;

import java.util.Stack;

public class QueueUsingStacks {
    static class Queue {
        Stack<Integer> stack;
    }

    static void push(Stack<Integer> stack, int val){
        stack.push(val);
    }

    static int pop(Stack<Integer> stack){
        if(stack.isEmpty())
            return Integer.MIN_VALUE;
        return stack.pop();
    }

    static void enQueue(Queue q, int val){
        push(q.stack, val);
    }

    static int deQueue(Queue q){
        if(q.stack.isEmpty())
            return Integer.MIN_VALUE;

        if(q.stack.size() == 1)
            return pop(q.stack);

        int lastBut = q.stack.pop();

        int res = deQueue(q);

        push(q.stack, lastBut);
        return res;
    }
}
