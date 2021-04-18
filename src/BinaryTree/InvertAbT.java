package BinaryTree;

// Invert a BT
public class InvertAbT {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);

        root.left = r;
        root.right = l;

        return root;
    }
}
