package BinarySearchTree;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

// Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
// It is a BST which means that the inorder traversal would give a sorted array of nums. And hence the diff between the inorder successor of a node and the node OR
// Inorder predecessor of a node and the node would give the desired answer.
public class MinimumAbsDiffInABST {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        inorder(root.right);
    }
}
