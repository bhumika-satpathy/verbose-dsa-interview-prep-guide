package BinaryTree;

// Find the kth ancestor of a node in a binary tree
public class KthAncestorNodeInABT {

    static int k = 0;

    Node kthAncestor(Node root, Node node){
        if(root == null)
            return null;

        if(root == node){// k = 1
            if(k > 0)
                k--;
            return node;
        }

        Node left = kthAncestor(root.left, node);
        Node right = kthAncestor(root.right, node);

        if(left != null || right != null){
            if(k == 0){
                System.out.println(root.data);
                return null;
            }
            if(k > 0)
                k--;
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

        k = 2;
        kthAncestor(root, root.left.left);
    }

}
