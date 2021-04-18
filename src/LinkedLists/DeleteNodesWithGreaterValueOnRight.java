package LinkedLists;

public class DeleteNodesWithGreaterValueOnRight {
    Node Solution(Node head){
        ReverseALL reverse = new ReverseALL();
        head = reverse.Solution(head);

        Node maxNode = head;
        Node curr = head, prev = null;

        while(curr != null){
            if(curr.data >= maxNode.data){
                maxNode = curr;
                prev = curr;
                curr = curr.next;
            } else {
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;
            }
        }

       head = reverse.Solution(head);
        return head;
    }
}
