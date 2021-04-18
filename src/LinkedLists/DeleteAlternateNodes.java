package LinkedLists;

public class DeleteAlternateNodes {
    void IterativeSolution(Node head){

        if(head == null || head.next == null)
            return;

        Node curr = head, next = null;

        while(curr != null){
            next = curr.next;
            if(curr.next != null)
                curr.next = next.next;
            else curr.next = null;
            curr = curr.next;
        }
    }

    void RecursiveSolution(Node head){
        if(head == null)
            return;

        Node node = head.next;
        if(node == null)
            return;

        head.next = node.next;
        RecursiveSolution(head.next);
    }
}
