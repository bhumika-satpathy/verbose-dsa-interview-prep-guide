package LinkedLists;

public class LengthOfLinkedList {
    int IterativeSolution(Node head){
        int cnt = 0;
        while(head != null){
            head = head.next;
            cnt++;
        }
        return cnt;
    }

    int RecursiveSolution(Node head){
        if(head == null)
            return 0;
        return 1 + RecursiveSolution(head.next);
    }
}
