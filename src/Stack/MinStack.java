package Stack;

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//Implement the MinStack class:
//
//MinStack() initializes the stack object.
//void push(val) pushes the element val onto the stack.
//void pop() removes the element on the top of the stack.
//int top() gets the top element of the stack.
//int getMin() retrieves the minimum element in the stack.

import java.util.Stack;

class MinStack {

    Stack<int[]> stk = new Stack<>();
    public MinStack() {

    }

    public void push(int val) {
        if(stk.isEmpty()){
            stk.push(new int[] {val, val});
        } else {
            stk.push(new int[]{val, Math.min(val, stk.peek()[1])});
        }
    }

    public void pop() {
        stk.pop();
    }

    public int top() {
        return stk.peek()[0];
    }

    public int getMin() {
        return stk.peek()[1];
    }
}
