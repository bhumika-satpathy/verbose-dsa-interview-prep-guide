package LinkedLists;

public class DeleteMiddle {
    void Solution(Node head){

        if(head == null || head.next == null)
            return;

        Node slow = head, fast = head, prevSlow = null;

        while(fast.next != null && fast.next.next != null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prevSlow.next = slow.next;
        slow.next = null;
    }
}
