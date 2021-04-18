package LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromAnUnsortedLL {
    // Doesn't preserve the order of the original linked list
    Node Solution(Node head){

        // Base condition
        if(head == null || head.next == null)
            return head;

        // Sort using Merge sort algorithm
        MergeSortLL mergeSort = new MergeSortLL();
        head = mergeSort.Solution(head);

        Node curr = head;

        while(curr != null){
            Node tmp = curr;

            while(tmp != null && tmp.data == curr.data)
                tmp = tmp.next;

            curr.next = tmp;
            curr = curr.next;
        }

        return head;
    }

    // Preserves the order
    void Solution2(Node head){
        Set<Integer> map = new HashSet<>();
        Node curr = head;
        Node prev = null;

        while(curr != null){
            if(map.contains(curr.data)){
                prev.next = curr.next;
            } else {
                prev = curr;
                map.add(curr.data);
            }
            curr = curr.next;
        }
    }
}
