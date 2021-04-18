package BinaryTree;

/*
Given a binary tree and a target integer x, delete all the leaf nodes having value as x. Also, delete the newly formed leaves with the target value as x.
 */
public class DeleteNodesWithTargetX {

    Node deleteNodesWithX(Node root, int x){
        if(root == null)
            return null;

        root.left = deleteNodesWithX(root.left, x);
        root.right = deleteNodesWithX(root.right, x);

        if(root.left == null && root.right == null && root.data == x)
            return null;

        return root;
    }

    void Solution(){
        Node root = new Node(10);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(1);
        root.right.right = new Node(3);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(3);

        deleteNodesWithX(root, 3);
        InorderTreeTraversal inorderTreeTraversal = new InorderTreeTraversal();
        inorderTreeTraversal.inorderUsingRecursion(root);
    }
}
