package BinaryTree;

public class MinimumAndMaximumInABT {
    int Minimum(Node root){
        if(root == null)
            return Integer.MAX_VALUE;

        return Math.min(root.data, Math.min(Minimum(root.left), Minimum(root.right)));
    }

    int Maximum(Node root){
        if(root == null)
            return Integer.MIN_VALUE;

        return Math.max(root.data, Math.max(Maximum(root.left), Maximum(root.right)));
    }
}