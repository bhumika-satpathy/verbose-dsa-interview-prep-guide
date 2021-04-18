package LinkedLists;

public class PrintReverseWithoutReversing {
    void Solution(Node head){
        if(head == null)
            return;
        Solution(head.next);
        System.out.println(head.data);
    }
}
