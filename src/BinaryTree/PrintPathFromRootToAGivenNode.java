package BinaryTree;

import java.util.Stack;

// Print path from root to a given node in a binary tree
public class PrintPathFromRootToAGivenNode {

    static Stack<Node> stk = new Stack<>();

    Node printPath(Node root, Node node){
        if(root == null)
            return null;

        if(root == node){
            stk.push(root);
            return root;
        }

        Node left = printPath(root.left, node);
        Node right = printPath(root.right, node);

        if(left != null || right != null){
            stk.push(root);
            return left != null ? left : right;
        }
        return null;
    }

    void Solution(){

        Node root=new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printPath(root, root.left.right);

        while(!stk.isEmpty()){
            System.out.print(stk.pop().data + " ");
        }
    }
}
