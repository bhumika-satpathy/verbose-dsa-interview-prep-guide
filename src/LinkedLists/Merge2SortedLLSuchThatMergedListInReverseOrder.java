package LinkedLists;

/*
    Approach:
    1. Reverse list A
    2. Reverse list B
    3. Merge the two lists
 */

public class Merge2SortedLLSuchThatMergedListInReverseOrder {

    Node mergeSort2Lists(Node list1, Node list2){
        if(list1 == null && list2 == null)
            return null;
        Node res = null;

        while(list1 != null && list2 != null){
            if(list1.data <= list2.data){
                Node tmp = list1.next;
                list1.next = res;
                res = list1;
                list1 = tmp;
            } else {
                Node tmp = list2.next;
                list2.next = res;
                res = list2;
                list2 = tmp;
            }
        }

        while(list1 != null){
            Node tmp = list1.next;
            list1.next = res;
            res = list1;
            list1 = tmp;
        }

        while(list2 != null){
            Node tmp = list2.next;
            list2.next = res;
            res = list2;
            list2 = tmp;
        }

        return res;
    }

    Node Solution(Node list1, Node list2){
        return mergeSort2Lists(list1, list2);
    }
}
