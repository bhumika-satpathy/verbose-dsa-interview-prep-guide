package BinaryTree;

// Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
//
//A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
// https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }

        if(isSame(root, subRoot)) {
            return true;
        }

        return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }

    boolean isSame(TreeNode r, TreeNode s) {
        if(r == null && s == null) {
            return true;
        }
        if(r == null || s == null) {
            return false;
        }

        if(r.val != s.val) {
            return false;
        }

        return isSame(r.left, s.left) && isSame(r.right, s.right);
    }
}
