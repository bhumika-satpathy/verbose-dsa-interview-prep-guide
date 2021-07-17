package BinarySearchTree;

// Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
// https://leetcode.com/problems/range-sum-of-bst/submissions/
public class RangeSumOfBST {
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return ans;
    }

    void dfs(TreeNode root, int l, int h) {
        if(root == null) {
            return;
        }
        if(root.val >= l && root.val <= h) {
            ans += root.val;
        }
        if(root.val >= l) {
            dfs(root.left, l, h);
        }
        if(root.val <= h) {
            dfs(root.right, l, h);
        }
    }
}
