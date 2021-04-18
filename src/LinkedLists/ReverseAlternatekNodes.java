package LinkedLists;

public class ReverseAlternatekNodes {
    Node Solution(Node head, int k, boolean reverse){
        if(head == null)
            return null;

        Node curr = head, next = null, prev = null;
        int cnt = 0;

        if(reverse){
            while(curr != null && cnt < k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                cnt++;
            }
            head.next = Solution(next, k, false);
            return prev;
        }

        while(curr != null && cnt < k){
            prev = curr;
            curr = curr.next;
            cnt++;
        }
        prev.next = Solution(curr, k, true);
        return head;
    }
}
