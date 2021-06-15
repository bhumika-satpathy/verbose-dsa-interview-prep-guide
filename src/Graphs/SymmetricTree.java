package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

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

  // ------------- Solution 1 --------- BFS -------------------------------------
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        TreeNode t1 = null, t2 = null;

        while(!q.isEmpty()) {
            t1 = q.poll();
            t2 = q.poll();

            if((t1 == null && t2 != null) || (t1 != null && t2 == null)) {
                return false;
            }

            if(t1 == null && t2 == null) {
                continue;
            }

            if((t1.val != t2.val)) {
                return false;
            }

            q.add(t1.right);
            q.add(t2.left);
            q.add(t1.left);
            q.add(t2.right);
        }
        return true;
    }

    // Solution-2 ------------------ DFS ---------------------
    boolean dfs(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) &&
                (dfs(t1.right, t2.left) && dfs(t1.left, t2.right));
    }

    public boolean isSymmetric2(TreeNode root) {
        if(root == null) {
            return true;
        }

        return dfs(root, root);
    }
}
