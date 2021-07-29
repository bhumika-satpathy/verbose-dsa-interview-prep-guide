package BinarySearchTree;

// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that
// has both p and q as descendants (where we allow a node to be a descendant of itself).”
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LCAInABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode par = root;

        if(par.val < p.val && par.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if(par.val > p.val && par.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}