package LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOf2SortedLL {
    Node Solution(Node head1, Node head2){
        Node dummy = new Node(0);

        while(head1 != null && head2 != null){
            if(head1.data == head2.data){
                int data = head1.data;
                dummy.next = new Node(data);
                dummy = dummy.next;
                head1 = head1.next;
                head2 = head2.next;
            }
            if(head1.data < head2.data){
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }

        return dummy.next;
    }
}
