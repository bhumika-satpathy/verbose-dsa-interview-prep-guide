package BinaryTree;

// Boundary Traversal Of a Binary Tree
public class BoundaryTraversalOfABT {

    void printLeftSide(Node root){
        if(root == null)
            return;

        if(root.left != null){
            System.out.print(root.data + " ");
            printLeftSide(root.left);
        } else if(root.right != null){
            System.out.print(root.data + " ");
            printLeftSide(root.right);
        }
    }

    void printRightSide(Node root){
        if(root == null)
            return;
        // Conditions to avoid duplicacy/ printing the leaf nodes again
        if(root.right != null){
            printRightSide(root.right);
            System.out.print(root.data + " ");
        } else if(root.left != null){
            printRightSide(root.left);
            System.out.print(root.data + " ");
        }
    }

    void printLeaves(Node root){
        if(root == null)
            return;

        if(root.left != null)
            printLeaves(root.left);
        if(root.right != null)
            printLeaves(root.right);

        if(root.left == null && root.right == null)
            System.out.print(root.data + " ");
    }

    void Solution(Node root){
        if(root == null)
            return;

        // Print left side of the binary tree
        printLeftSide(root);

        // Print leaves
        printLeaves(root);

        // Print right side of the binary tree
        printRightSide(root.right);
    }
}
