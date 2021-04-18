package LinkedLists;

public class PairWiseSwapNodes {
    Node Solution(Node head){
        Node next = head.next, curr = head;
        head = head.next;

        while(next != null && curr != null){
            Node tmp = next.next;
            if(tmp == null || tmp.next == null) {
                curr.next = tmp;
                next.next = curr;
                break;
            }
            curr.next = next.next.next;
            next.next = curr;
            curr = tmp;
            next = curr.next;
        }
        return head;
    }
}
