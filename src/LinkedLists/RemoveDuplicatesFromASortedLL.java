package LinkedLists;

public class RemoveDuplicatesFromASortedLL {
    void Solution(Node head){
        Node curr = head;
        while(curr != null){
            Node tmp = curr;

            while(tmp != null && tmp.data == curr.data)
                tmp = tmp.next;

            curr.next = tmp;
            curr = curr.next;
        }
    }
}
