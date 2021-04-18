package LinkedLists;

public class IsPalindrome {

    boolean areEqual(Node str1, Node str2){
        while(str1 != null && str2 != null){
            if(str1.data != str2.data)
                return false;
            str1 = str1.next;
            str2 = str2.next;
        }
        if(str1 != null || str2 != null)
            return false;
        return true;
    }

    Node reverse(Node head){
        Node curr = head;
        Node next = null;
        Node prev = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    boolean Solution(Node head){
        Node slow = head;
        Node fast = head;
        Node prev = null;
        Node mid = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        // Odd number of nodes in the linked list
        if(fast != null){
            mid = slow;
            slow = slow.next;
        }

        prev.next = null;

        Node secondHalf = slow;
        secondHalf = reverse(secondHalf);

        boolean res = areEqual(head, secondHalf);
        secondHalf = reverse(secondHalf);
        if(mid != null){
            prev.next = mid;
            mid.next = secondHalf;
        } else prev.next = secondHalf;

        return res;
    }
}
