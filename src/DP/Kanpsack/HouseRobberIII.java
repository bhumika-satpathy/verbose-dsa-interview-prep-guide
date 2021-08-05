package DP.Kanpsack;

import java.util.*;

// The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
//
//Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
//
//Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
// https://leetcode.com/problems/house-robber-iii/
public class HouseRobberIII {

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

    HashMap<TreeNode, Integer> nodesRobbed = new HashMap<>();
    HashMap<TreeNode, Integer> nodesNotRobbed = new HashMap<>();

    int helper(TreeNode root, boolean parentRobbed) {
        if(root == null) {
            return 0;
        }

        if(parentRobbed) {
            if(nodesNotRobbed.containsKey(root)) {
                return nodesNotRobbed.get(root);
            }
            int res = helper(root.left, false) + helper(root.right, false);
            nodesNotRobbed.put(root, res);
            return res;
        } else {
            if(nodesRobbed.containsKey(root)) {
                return nodesRobbed.get(root);
            }
            int rob = root.val + helper(root.left, true) + helper(root.right, true);
            int notRob = helper(root.left, false) + helper(root.right, false);
            int res = Math.max(rob, notRob);

            nodesRobbed.put(root, res);
            return res;
        }
    }
    public int rob(TreeNode root) {
        return helper(root, false);
    }
}
