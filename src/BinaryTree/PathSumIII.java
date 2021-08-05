package BinaryTree;

import java.util.HashMap;

// Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
//
//The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
// https://leetcode.com/problems/path-sum-iii/
public class PathSumIII {
    int target;
    private HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;

    public void path(TreeNode root, int sum) {
        if(root == null) {
            return;
        }

        sum += root.val;
        if(map.containsKey(sum - target)) {
            count += map.get(sum - target);
        }
        int cnt = map.getOrDefault(sum, 0);
        map.put(sum, cnt + 1);

        path(root.left, sum);
        path(root.right, sum);

        map.put(sum, map.get(sum) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        map.put(0, 1);
        path(root, 0);
        return count;
    }
}
