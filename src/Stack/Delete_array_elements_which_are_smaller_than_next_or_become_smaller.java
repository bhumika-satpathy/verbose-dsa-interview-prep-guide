package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// Delete k array elements which are smaller than next or become smaller
public class Delete_array_elements_which_are_smaller_than_next_or_become_smaller {

    int[] Solution(int[] arr, int k){
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++){
            int ele = arr[i];
            while(!stack.isEmpty() && stack.peek() < ele && cnt < k){
                stack.pop();
                cnt++;
            }
            stack.push(ele);
        }

        List<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty())
            ans.add(stack.pop());
        Collections.reverse(ans);

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
