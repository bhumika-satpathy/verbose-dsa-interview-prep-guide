package BinarySearchTree;

// Insert a node in a BST
public class InsertNodeInABST {

    Node InsertANode(Node root, int key){
        if(root == null)
            return new Node(key);

        if(root.data > key)
            root.left = InsertANode(root.left, key);

        else root.right = InsertANode(root.right, key);

        return root;
    }

}
