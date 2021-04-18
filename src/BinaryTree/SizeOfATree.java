package BinaryTree;

public class SizeOfATree {
    int Solution(Node root){
        if(root == null)
            return 0;
        return 1 + Solution(root.left) + Solution(root.right);
    }
}
