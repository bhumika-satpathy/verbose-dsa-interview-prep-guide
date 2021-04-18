package BinaryTree;

import java.util.*;

class pair {
    TreeNode root;
    int col;

    pair(TreeNode root, int col){
        this.root = root;
        this.col = col;
    }
}

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        int min = 0, max = 0;
        HashMap<Integer, List<Integer>> colTable = new HashMap<>();
        int col = 0;

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root, 0));

        while(!q.isEmpty()){
            pair p = q.poll();
            col = p.col;
            root = p.root;

            if(root != null){
                if(!colTable.containsKey(col)){
                    colTable.put(col, new ArrayList<>());
                }
                colTable.get(col).add(root.val);
                min = Math.min(min, col);
                max = Math.max(max, col);

                if(root.left != null){
                    q.add(new pair(root.left, col - 1));
                }
                if(root.right != null){
                    q.add(new pair(root.right, col + 1));
                }
            }
        }

        for(int i = min ; i <= max; i++){
            ans.add(colTable.get(i));
        }
        return ans;
    }
}
