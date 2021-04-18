package LinkedLists;

// Time complex: O(nklogk)
// Space complex: O(1)
public class MergeKSortedLL {
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    ListNode mergeSort(ListNode p1, ListNode p2){
        ListNode res = null;

        if(p1 == null)
            return p2;
        if(p2 == null)
            return p1;

        if(p1.val <= p2.val){
            res = p1;
            res.next = mergeSort(p1.next, p2);
        } else {
            res = p2;
            res.next = mergeSort(p1, p2.next);
        }

        return res;
    }

    ListNode mergeLists(ListNode[] lists, int last){
        while(last != 0){
            int i = 0, j = last;

            while(i < j){
                lists[i] = mergeSort(lists[i], lists[j]);
                i++;
                j--;
            }

            if(i >= j)
                last = j;
        }
        return lists[0];
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        return mergeLists(lists, lists.length - 1);
    }
}
