package Stack;

import java.util.Stack;

public class NextGreaterFrequencyElement {
    int[] Solution(int[] arr){
        int n = arr.length, max = Integer.MIN_VALUE;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            max = arr[i] >= max ? arr[i] : max;
        }

        int[] freq = new int[max + 1];
        for(int i = 0; i < n; i++)
            freq[arr[i]]++;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < n; i++){
            int curr = arr[i];

            if(!stack.isEmpty()){
                if(freq[arr[stack.peek()]] > freq[curr])
                    stack.push(i);

                else {
                    while(!stack.isEmpty() && freq[arr[stack.peek()]] < freq[curr]){
                        res[stack.peek()] = curr;
                        stack.pop();
                    }
                    stack.push(i);
                }
            }
        }

        while(!stack.isEmpty()){
            res[stack.pop()] = -1;
        }

        return res;
    }

    int[] Solution2(int[] arr){
        int n = arr.length, max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            max = arr[i] >= max ? arr[i] : max;
        }

        int[] freq = new int[max + 1];
        for(int i = 0; i < n; i++)
            freq[arr[i]]++;

        for(int i = arr.length - 1; i >= 0; i--){
            int curr = arr[i];

            while(!stack.isEmpty() && freq[arr[stack.peek()]] <= freq[curr])
                stack.pop();

            res[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i);
        }

        return res;
    }

}
