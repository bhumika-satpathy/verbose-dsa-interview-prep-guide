package Graphs;

import java.util.*;

// We are given a binary tree (with root node root), a target node, and an integer value k.
//
//Return a list of the values of all nodes that have a distance k from the target node.  The answer can be returned in any order.
// reference video: https://www.youtube.com/watch?v=nPtARJ2cYrg
public class AllNodesAtDistanceKFromTarget {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    Map<TreeNode, TreeNode> childWithParent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        childWithParent = new HashMap<>();
        // Store all the childrens' parents
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        // denote that this is level 0 by adding a null
        // An addition of null few denotes an end of a particular level
        queue.add(null);
        queue.add(target);

        // seen map denotes the nodes that are already seen so that they are not traversed again
        HashSet<TreeNode> seen = new HashSet<>();
        seen.add(target);
        seen.add(null);
        int dist = 0;

        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if(tmp == null) {
                if(dist == K) {
                    List<Integer> ans = new ArrayList<>();
                    for(TreeNode node: queue) {
                        ans.add(node.val);
                    }
                    return ans;
                }
                queue.add(null);
                dist++;
            } else {
                if(!seen.contains(tmp.left)) {
                    seen.add(tmp.left);
                    queue.add(tmp.left);
                }
                if(!seen.contains(tmp.right)) {
                    seen.add(tmp.right);
                    queue.add(tmp.right);
                }
                TreeNode parent = childWithParent.get(tmp);
                if(!seen.contains(parent)) {
                    seen.add(parent);
                    queue.add(parent);
                }
            }
        }

        return new ArrayList<>();
    }

    void dfs(TreeNode child, TreeNode parent) {
        childWithParent.put(child, parent);
        if(child.left != null) {
            dfs(child.left, child);
        }
        if(child.right != null) {
            dfs(child.right, child);
        }
    }
}
