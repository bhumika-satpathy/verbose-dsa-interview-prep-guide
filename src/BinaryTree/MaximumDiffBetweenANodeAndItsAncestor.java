package BinaryTree;

class Res {
    int r = Integer.MIN_VALUE;
}

public class MaximumDiffBetweenANodeAndItsAncestor {

    int maxDiff(Node root, Res res){
        if(root == null)
            return Integer.MAX_VALUE;

        if(root.left == null && root.right == null)
            return root.data;

        int val = Math.min(maxDiff(root.left, res), maxDiff(root.right, res));
        res.r = Math.max(res.r, root.data - val);

        return Math.min(root.data, val);
    }

    int Solution(Node root){
        if(root == null)
            return 0;

        Res res = new Res();
        maxDiff(root, res);

        return res.r;
    }
}
