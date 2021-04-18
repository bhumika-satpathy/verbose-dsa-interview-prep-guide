package LinkedLists;

public class DeleteNode {
    public Node Solution(Node head, int key){
        Node tmp = head;
        if(tmp != null && tmp.data == key){
            tmp = tmp.next;
            head = tmp;
            return head;
        }
        Node prev = null;
        while(tmp != null && tmp.data != key){
            prev = tmp;
            tmp = tmp.next;
        }

        if(tmp == null)
            return head;
        prev.next = tmp.next;
        return head;
    }
}
