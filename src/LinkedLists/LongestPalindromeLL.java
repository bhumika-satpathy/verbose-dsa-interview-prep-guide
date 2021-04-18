package LinkedLists;

// Given a linked list, find length of the longest palindrome list that exist in that linked list.
public class LongestPalindromeLL {

    int countCommonNodes(Node list1, Node list2){
        int cnt = 0;
        while(list1 != null && list2 != null){
            if(list1.data == list2.data)
                cnt++;
            else break;
            list1 = list1.next;
            list2 = list2.next;
        }
        return cnt;
    }

    int longestPalindromeLinkedList(Node node){
        if(node == null)
            return 0;

        int result = 0, count = 0;

        Node curr = node, prev = null, next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;

            // For odd length list
            // No of common nodes = 2 * common length + 1 for the curr node
            count = 2 * countCommonNodes(prev, next) + 1;
            result = Math.max(result, count);

            // For even length list
            count = 2 * countCommonNodes(curr, next);
            result = Math.max(result, count);

            prev = curr;
            curr = next;
        }
        return result;
    }

}
