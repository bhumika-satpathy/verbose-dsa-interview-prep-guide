package LinkedLists;

/*
Approach:
 1. Sort b in ascending order and c in descending order
 2. After the b and c are sorted, one by one pick an element from list a and find the pair by traversing both b and c.
 */
public class TripletFrom3LLWithSumEqualToGivenNumber {
    boolean isTripletPresent(Node head1, Node head2, Node head3, int givenNumber){

        // Sort second linked list in ascending order and third in descending order
        MergeSortLL mergeSort = new MergeSortLL();
        head2 = mergeSort.Solution(head2);

        MergeSortDescending mergeSortDescending = new MergeSortDescending();
        head3 = mergeSortDescending.Solution(head3);

        while(head1 != null){
            Node b = head2, c = head3;
            while(b != null && c != null){
                int sum = head1.data + b.data + c.data;

                if(sum == givenNumber){
                    System.out.println("Triplet found: " + head1.data + " " + b.data + " " + c.data);
                    return true;
                }

                if(sum < givenNumber)
                    b = b.next;
                if(sum > givenNumber)
                    c = c.next;
            }
            head1 = head1.next;
        }
        return false;
    }
}
