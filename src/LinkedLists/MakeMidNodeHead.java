package LinkedLists;

public class MakeMidNodeHead {
    Node Solution(Node head){
        Node slow = head, fast = head, prevSlow = null;

        while(fast.next != null && fast.next.next != null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prevSlow.next = slow.next;
        slow.next = head;
        head = slow;
        return head;
    }
}
