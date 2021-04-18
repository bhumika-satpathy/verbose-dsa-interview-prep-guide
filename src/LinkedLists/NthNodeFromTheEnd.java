package LinkedLists;

public class NthNodeFromTheEnd {
    Node Solution(Node head, int n){
        Node mainPtr = head;
        Node refPtr = head;
        int cnt = 1;

        while(refPtr != null && cnt < n){
            refPtr = refPtr.next;
            cnt++;
        }

        while(refPtr.next != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }

        return mainPtr;
    }
}