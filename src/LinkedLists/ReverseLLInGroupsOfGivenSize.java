package LinkedLists;

import java.util.Stack;

public class ReverseLLInGroupsOfGivenSize {
    Node Solution(Node head, int k){
        if(head == null)
            return null;

        Node curr = head, next = null, prev = null;
        int cnt = 0;

        while(curr != null && cnt < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }

        if(next != null){
            head.next = Solution(next, k);
        }

        return prev;
    }

    // Using Stack
    Node Solution2(Node head, int k){
        Node curr = head, prev = null;
        int cnt = 0;
        Stack<Node> stack = new Stack<>();

        while(curr != null){
            cnt = 0;
            while(curr != null && cnt < k){
                stack.push(curr);
                curr = curr.next;
                cnt++;
            }

            while(stack.size() > 0){
                if(prev == null){
                    prev = stack.peek();
                    head = prev;
                    stack.pop();
                } else {
                    prev.next = stack.peek();
                    prev = prev.next;
                    stack.pop();
                }
            }
        }
        prev.next = null;
        return head;
    }
}
