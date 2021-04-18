package LinkedLists;

// Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …
//You are required to do this in-place without altering the nodes’ values.
public class RearrangeGivenList {

    Node reverse(Node head){
        Node curr = head, prev = null, next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    Node Solution(Node head){
        if(head == null || head.next == null)
            return head;

        Node node1 = head, node2 = null;
        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        node2 = slow.next;
        node2 = reverse(node2);

        head = new Node(0);
        Node curr = head;

        while(node1 != null || node2 != null){
            if(node1 != null){
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }
            if(node2 != null){
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }

        head = head.next;
        return head;
    }

}
