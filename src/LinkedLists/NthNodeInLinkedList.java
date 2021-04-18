package LinkedLists;

public class NthNodeInLinkedList {
    Node IterativeSolution(Node head, int n){
        int cnt = 1;
        while(head.next != null){
            if(cnt == n)
                return head;
            cnt++;
            head = head.next;
        }
        return null;
    }

    Node RecursiveSolution(Node head, int n, int nodeNumber){
        if(head == null)
            return null;
        if(nodeNumber == n && head != null)
            return head;
        return RecursiveSolution(head.next, n, nodeNumber + 1);
    }
}
