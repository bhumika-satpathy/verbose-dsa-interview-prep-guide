package LinkedLists;

public class SearchAnElement {
    boolean IterativeSolution(Node head, int val){
        if(head == null)
            return false;
        while(head != null){
            if(head.data == val)
                return true;
            head = head.next;
        }
        return false;
    }

    boolean RecursiveSolution(Node head, int val){
        if(head == null)
            return false;
        if(head.data == val)
            return true;
        return RecursiveSolution(head.next, val);
    }
}
