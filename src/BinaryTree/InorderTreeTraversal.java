package BinaryTree;

import java.util.Stack;

public class InorderTreeTraversal {
    // Using Recursion
    void inorderUsingRecursion(Node root){
        if(root == null)
            return;
        inorderUsingRecursion(root.left);
        System.out.println(root.data);
        inorderUsingRecursion(root.right);
    }

    // Without using Recursion
    void inorderWithoutRecursion(Node root){
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node curr = root;

        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.println(curr.data);
            curr = curr.right;
        }
    }

    // Using Morris Traversal.
    // Space Complex: O(1)
    void inorderMorris(Node root){
        if(root == null)
            return;

        Node curr = root;
        Node prev = null;

        while(curr != null){
            if(curr.left == null){
                System.out.println(curr.data);
                curr = curr.right;
            }

            else {
                prev = curr.left;

                // Find the inorder predecessor of the node
                while(prev.right != null && prev.right != curr)
                    prev = prev.right;

                // Build a link between the inorder predecessor and the root(next to the inorder predecessor)
                // Make current as right child of its inorder predecessor
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                // If the link already exists, then it essentially means that the curr node is where it is only after traversing through its predecessor
                // which means that the predecessor is already traversed and the curr needs to be printed
                else {
                    prev.right = null;
                    System.out.println(curr.data);
                    curr = curr.right;
                }
            }
        }
    }
}
