package LinkedLists;

// Use Merge Sort Algorithm to sort a linked list
public class MergeSortLL {

    Node getMiddle(Node head){
        if(head == null)
            return head;
        Node slow = head;
        Node fast = head;

        while(slow != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Node mergeSort(Node firstHalf, Node secondHalf){
        Node result = null;

        if(firstHalf == null)
            return secondHalf;
        if(secondHalf == null)
            return firstHalf;

        if(firstHalf.data <= secondHalf.data){
            result = firstHalf;
            result.next = mergeSort(firstHalf.next, secondHalf);
        } else {
            result = secondHalf;
            result.next = mergeSort(firstHalf, secondHalf.next);
        }

        return result;
    }

    Node Solution(Node head){

        // Base condition
        if(head == null || head.next == null)
            return head;

        // Get the middle of a linked list
        Node mid = getMiddle(head);
        Node nextOfMid = mid.next;
        mid.next = null;

        // Divide the linked list into two halves
        Node firstHalf = Solution(head);
        Node secondHalf = Solution(nextOfMid);

        // Merge sort both the halves
        head = mergeSort(firstHalf, secondHalf);

        return head;
    }
}
