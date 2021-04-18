package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> ans = new ArrayList<>();

        TreeNode curr = null, prev = null;

        while(!q.isEmpty()){
            curr = q.poll();

            while(curr != null){
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                prev = curr;
                curr = q.poll();
            }
            ans.add(prev.val);

            if(!q.isEmpty())
                q.add(null);
        }

        return ans;
    }
}
