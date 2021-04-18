package LinkedLists;

public class LengthOfLoopInALL {

    int countNodesInLoop(Node head){
        Node tmp = head;
        int cnt = 1;
        while(tmp.next != head){
            tmp = tmp.next;
            cnt++;
        }
        return cnt;
    }

    int lengthOfLoop(Node head){
        Node slow = head;
        Node fast = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return countNodesInLoop(slow);
            }
        }
        return 0;
    }
}
