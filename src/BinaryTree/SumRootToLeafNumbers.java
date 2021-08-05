package BinaryTree;

// You are given the root of a binary tree containing digits from 0 to 9 only.
//Each root-to-leaf path in the tree represents a number.
// For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
//A leaf node is a node with no children.
// https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRootToLeafNumbers {
    public int sumPath(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }

        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null) {
            return sum;
        }

        int left = sumPath(root.left, sum);
        int right = sumPath(root.right, sum);

        return left + right;
    }

    public int sumNumbers(TreeNode root) {
        return sumPath(root, 0);
    }
}
