package BinarySearchTree;

public class InorderTraversal {
    void inorderTraversal(Node root){
        if(root == null)
            return;

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }
}
