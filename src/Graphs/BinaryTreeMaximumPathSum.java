package Graphs;

// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
//The path sum of a path is the sum of the node's values in the path.
//Given the root of a binary tree, return the maximum path sum of any path.
public class BinaryTreeMaximumPathSum {

    public class TreeNode {
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

    int maxSum = Integer.MIN_VALUE;

    public int maxSumPath(TreeNode root){
        if(root == null)
            return 0;

        int leftSum = Math.max(maxSumPath(root.left), 0);
        int rightSum = Math.max(maxSumPath(root.right), 0);

        int pathSum = leftSum + rightSum + root.val;

        maxSum = Math.max(maxSum, pathSum);

        return root.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        maxSumPath(root);
        return maxSum;
    }
}
