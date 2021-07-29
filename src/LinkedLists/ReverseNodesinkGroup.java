package LinkedLists;

// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
//k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
//
//You may not alter the values in the list's nodes, only nodes themselves may be changed.
// https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesinkGroup {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        int cnt = 0;
        ListNode curr = head, prev = null, next = null;

        while(curr != null && cnt < k) {
            curr = curr.next;
            cnt++;
        }

        if(cnt == k) {
            cnt = 0;
            curr = head;
            while(curr != null && cnt < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                cnt++;
            }
            head.next = reverseKGroup(curr, k);
            return prev;
        }
        return head;
    }
}
