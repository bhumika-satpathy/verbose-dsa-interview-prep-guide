package LinkedLists;

// Given the head of a linked list, rotate the list to the right by k places.
// https://leetcode.com/problems/rotate-list/
public class RotateList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        int n;
        ListNode oldTail = head;
        // Calculates the total number of nodes
        for(n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;

        ListNode newTail = head;
        for(int i = 0; i < (n - k % n - 1); i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
