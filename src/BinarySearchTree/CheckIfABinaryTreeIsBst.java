package BinarySearchTree;

// Check if a binary tree is a bst or not
public class CheckIfABinaryTreeIsBst {

    boolean isBst(Node root, Node min, Node max){
        if(root == null)
            return true;

        if(min != null && root.data <= min.data)
            return false;
        if(max != null && root.data >= max.data)
            return false;

        return isBst(root.left, min, root) && isBst(root.right, root, max);
    }

    boolean Solution(Node root){
        return isBst(root, null, null);
    }
}
