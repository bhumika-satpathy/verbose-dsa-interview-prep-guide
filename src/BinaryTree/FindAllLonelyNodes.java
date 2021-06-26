package BinaryTree;

import java.util.*;

// In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.
//
//Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree. Return the list in any order.
// https://leetcode.com/problems/find-all-the-lonely-nodes/
public class FindAllLonelyNodes {
    List<Integer> ans = new ArrayList<>();

    TreeNode lonely(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left = lonely(root.left);
        TreeNode right = lonely(root.right);

        if(left == null && right == null) {
            return root;
        }

        if(left == null) {
            ans.add(right.val);
        }
        if(right == null) {
            ans.add(left.val);
        }
        return root;
    }

    public List<Integer> getLonelyNodes(TreeNode root) {
        lonely(root);
        return ans;
    }
}
