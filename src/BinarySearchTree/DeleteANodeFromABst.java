package BinarySearchTree;

import BinaryTree.InsertionInABinaryTree;

// Delete a specific node from a tree
/*
Delete Node types:
    1. Leaf node
    2. Node with a single child
    3. Node with 2 children
 */
public class DeleteANodeFromABst {

    int minValue(Node root){
        if(root == null)
            return Integer.MAX_VALUE;

        if(root.left == null && root.right == null)
            return root.data;

        return minValue(root.left);
    }

    Node deleteNode(Node root, int key){
        if(root == null)
            return root;

        if(root.data > key)
            root.left = deleteNode(root.left, key);
        else if(root.data < key)
            root.right = deleteNode(root.right, key);

        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = deleteNode(root.right, root.data);
        }

        return root;
    }

    void Solution(){
        Node root = new Node(3);
        InsertNodeInABST insertNodeInABST = new InsertNodeInABST();
        root = insertNodeInABST.InsertANode(root, 1);
        root = insertNodeInABST.InsertANode(root, 1);
        root = insertNodeInABST.InsertANode(root, 2);
        root = insertNodeInABST.InsertANode(root, 5);
        root = insertNodeInABST.InsertANode(root, 6);
        root = insertNodeInABST.InsertANode(root, 8);

        InorderTraversal inorderTraversal = new InorderTraversal();
        inorderTraversal.inorderTraversal(root);

        System.out.println();

        root = deleteNode(root, 1);
        inorderTraversal.inorderTraversal(root);
    }

}
