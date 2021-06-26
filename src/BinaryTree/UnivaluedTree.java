package BinaryTree;

// A binary tree is univalued if every node in the tree has the same value.
//
//Return true if and only if the given tree is univalued.
// https://leetcode.com/problems/univalued-binary-tree/
public class UnivaluedTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) {
            return true;
        }

        boolean isLeftUniVal = isUnivalTree(root.left);
        boolean isRightUniVal = isUnivalTree(root.right);

        if((root.left != null && root.val != root.left.val) || (root.right != null && root.val != root.right.val)) {
            return false;
        }

        return isLeftUniVal && isRightUniVal;
    }
}
