package LinkedLists;

public class ReverseALL {
    Node Solution(Node head){
        Node curr = head, prev = null, next = head;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
