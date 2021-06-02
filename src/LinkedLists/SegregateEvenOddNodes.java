package LinkedLists;

public class SegregateEvenOddNodes {
    Node Solution(Node head){

        if(head == null || head.next == null)
            return head;

        Node end = head, prev = null, curr = head;

        while(end.next != null)
            end = end.next;

        Node newEnd = end;

        while(curr.data % 2 != 0 && curr != end){
            newEnd.next = curr;
            curr = curr.next;
            newEnd.next.next = null;
            newEnd = newEnd.next;
        }

        if(curr.data % 2 == 0){
            head = curr;

            while(curr != end){
                if(curr.data % 2 == 0){
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    newEnd.next = curr;
                    curr = prev.next;
                    newEnd = newEnd.next;
                }
            }
        } else prev = curr;

        if(newEnd != end && end.data % 2 != 0){
            prev.next = end.next;
            newEnd.next = end;
            newEnd.next.next = null;
        }
        return head;
    }
}
