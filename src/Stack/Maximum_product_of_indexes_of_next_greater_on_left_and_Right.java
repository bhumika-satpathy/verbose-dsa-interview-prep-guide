package Stack;

import java.util.Stack;

public class Maximum_product_of_indexes_of_next_greater_on_left_and_Right {

    int[] nextGreaterElementToRight(int[] arr){
        int[] left = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek() - 1])
                stack.pop();

            left[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i + 1);
        }

        return left;
    }

    int[] nextGreaterElementToLeft(int[] arr){
        int[] right = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek() - 1])
                stack.pop();

            right[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i + 1);
        }

        return right;
    }

    int Solution(int[] arr){
        Stack<Integer> stack = new Stack<>();

        int[] leftGreaterIndices = nextGreaterElementToLeft(arr);
        int[] rightGreaterIndices = nextGreaterElementToRight(arr);

        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max = leftGreaterIndices[i] * rightGreaterIndices[i] > max ? leftGreaterIndices[i] * rightGreaterIndices[i] : max;
        }
        return max;
    }
}
