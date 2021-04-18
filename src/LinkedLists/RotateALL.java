package LinkedLists;

// 10 20 30 40 50 60, k = 4
// 50 60 10 20 30 40  => Ans
public class RotateALL {
    Node Solution(Node head, int k){
        Node curr = head;

        while(curr.next != null)
            curr = curr.next;

        curr.next = head;
        curr = head;

        for(int i = 1; i < k; i++){
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }
}
