package Stack;

import java.util.Stack;

public class NextGreaterElement {
    void Solution(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--){
            int element = arr[i];

            if(!stack.isEmpty()){
                while(stack.isEmpty() == false && stack.peek() <= element)
                    stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(element);
        }

        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i] + "----->" + ans[i]);
    }
}
