package LinkedLists;

// Remove all occurances o duplicates from a sorted linked list
public class RemoveAllOccurancesOfDupsFromSortedLL {
    Node Solution(Node head){
        if(head == null || head.next != null)
            return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;

        while(curr != null){
            while(curr.next != null && prev.next.data == curr.next.data)
                curr = curr.next;

            if(prev.next == curr) {
                prev = prev.next;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}