package LinkedLists;

public class DeleteGivenPosition {
    public Node Solution(Node head, int pos){
        int index = 0;
        if(index == pos){
            head = head.next;
            return head;
        }
        Node prev = null;
        Node tmp = head;
        while(tmp != null && index != pos){
            prev = tmp;
            tmp = tmp.next;
            index++;
        }
        prev.next = tmp.next;
        return head;
    }
}
