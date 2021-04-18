package LinkedLists;

public class MoveLastElementToFirst {
    Node Solution(Node head){

        if(head == null || head.next == null)
            return head;

        Node secondLast = head, last = head;

        while(last.next != null){
            secondLast = last;
            last = last.next;
        }

        secondLast.next = null;
        last.next = head;
        head = last;

        return head;
    }
}
