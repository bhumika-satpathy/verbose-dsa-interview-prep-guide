package BinaryTree;

public class PrintAncestorsOfAGivenNode {

    Node printAncestors(Node root, Node node){
        if(root == null)
            return null;

        if(root == node)
            return node;

        Node left = printAncestors(root.left, node);
        Node right = printAncestors(root.right, node);

        if(left != null || right != null){
            System.out.print(root.data + " ");
            // could return root or left or right because it doesn't really matter
            return root;
        }

        return null;
    }

    void Solution(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);

        printAncestors(root,root.left.left.left);
    }
}
