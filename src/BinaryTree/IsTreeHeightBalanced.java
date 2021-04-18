package BinaryTree;

/*
Consider a height-balancing scheme where following conditions should be checked to determine if a binary tree is balanced.
An empty tree is height-balanced. A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced
2) Right subtree of T is balanced
3) The difference between heights of left subtree and right subtree is not more than 1.
 */
public class IsTreeHeightBalanced {

    int height(Node root){
        if(root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + (lh > rh ? lh : rh);
    }

    boolean isBalanced(Node root){
        if(root == null)
            return true;

        int lh = height(root.left);
        int rh = height(root.right);

        if(Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    void Solution(){

    }

}
