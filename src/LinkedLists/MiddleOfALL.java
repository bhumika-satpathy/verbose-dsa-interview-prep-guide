package LinkedLists;

public class MiddleOfALL {
    Node Solution(Node head){
        Node slowPtr = head;
        Node fastPtr = head;

        if(head == null)
            return null;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
}
