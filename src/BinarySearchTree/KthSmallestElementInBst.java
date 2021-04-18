package BinarySearchTree;

// Find the kth smallest element in bst without using extra space
// Time complex: O(n)
// SPace complex: O(1)
public class KthSmallestElementInBst {

    int kthSmallestElement(Node root, int k){
        if(root == null)
            return Integer.MIN_VALUE;

        Node curr = root;
        Node prev = null;
        int cnt = 0, kSmall = Integer.MIN_VALUE;

        while(curr != null){
            if(curr.left == null){
                cnt++;
                if(cnt == k)
                    kSmall = curr.data;
                curr = curr.right;
            } else {
                prev = curr.left;

                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    curr = curr.right;
                    cnt++;
                    if(cnt == k)
                        kSmall = curr.data;
                    prev.right = null;
                }
            }
        }
        return kSmall;
    }
}
