package LinkedLists;

public class NumberOfTimesGivenIntOccurs {
    int IterativeSolution(Node head, int key){
        int cnt = 0;
        while(head != null){
            if(head.data == key)
                cnt++;
            head = head.next;
        }
        return cnt;
    }

    int RecursiveSolution(Node head, int key){
        if(head == null)
            return 0;
        if(head.data == key)
            return 1 + RecursiveSolution(head.next, key);
        return RecursiveSolution(head.next, key);
    }
}
