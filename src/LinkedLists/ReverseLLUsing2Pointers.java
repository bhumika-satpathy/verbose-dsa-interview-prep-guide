package LinkedLists;

public class ReverseLLUsing2Pointers {
    Node Solution(Node head){

        if(head == null || head.next == null)
            return head;

        Node curr = head, next = null;

        while(curr.next != null){
            next = curr.next;
            curr.next = next.next;
            next.next = head;
            head = next;
        }

        return head;
    }
}
