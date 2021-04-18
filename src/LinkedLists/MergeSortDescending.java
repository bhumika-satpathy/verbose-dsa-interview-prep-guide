package LinkedLists;

public class MergeSortDescending {

    Node mergeSort(Node head1, Node head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

        Node res = null;

        if(head1.data >= head2.data){
            res = head1;
            res.next = mergeSort(head1.next, head2);
        } else {
            res = head2;
            res.next = mergeSort(head1, head2.next);
        }

        return res;
    }

    Node findMid(Node head){
        if(head == null || head.next == null)
            return head;

        Node slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    Node Solution(Node head){
        if(head == null || head.next == null)
            return head;

        Node midNode = findMid(head);
        Node nextOfMid = midNode.next;
        midNode.next = null;

        Node firstHalf = Solution(head);
        Node secondHalf = Solution(nextOfMid);

        head = mergeSort(firstHalf, secondHalf);

        return head;
    }
}
