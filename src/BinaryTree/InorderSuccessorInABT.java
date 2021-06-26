package BinaryTree;

// Use this while using the recursion technique
class PNode {
    Node pNode;

    PNode(){
        pNode = null;
    }
}


/*
    Approach:
    1. Check if there are any right nodes. If yes, return that
    2. Check if the target node is the rightmost node. If yes, return null.
    3. If you've come this far, then the node lies in the left subtree of the root. Return the node to which the target is the immediate left.
*/
public class InorderSuccessorInABT {

    Node leftMost(Node root){
        if(root == null)
            return root;

        while(root.left != null)
            root = root.left;

        return root;
    }

    Node rightMost(Node root){
        if(root == null)
            return null;

        while(root.right != null)
            root = root.right;

        return root;
    }

    Node tmp = new Node();

    Node findInorderSuccessor(Node root, Node x){
        if(root == null)
            return null;
        if(root == x || (tmp = findInorderSuccessor(root.right, x)) != null || (tmp = findInorderSuccessor(root.left, x)) != null){
            if(tmp != null){
                if(root.left == tmp){
                    System.out.print("Inorder Successor of " + x.data + " is ");
                    System.out.print(root.data);
                    return null;
                }
            }
            return root;
        }

        return null;
    }

    Node Solution(Node root, Node x){
        if(root == null)
            return null;

        // If the right node is not null, successor exists to the right
        if(x.right != null){
            return leftMost(x.right);
        }

        // If the right most node is x, then no successor of x exists
        Node rightMostNode = rightMost(root);
        if(rightMostNode == x)
            return null;

        Node y = findInorderSuccessor(root, x);
        return y;
    }

    // Using Recursion
    void findInorderRecursive(Node root, int searchNode, PNode pNode){
        if(root == null)
            return;

        if(root.right != null)
            findInorderRecursive(root.right, searchNode, pNode);

        if(root.data == searchNode)
            System.out.println("Inorder successor of " + searchNode + " is: " + (pNode == null ? null : pNode.pNode.data));

        // Store previous (essentially the successor node)
        pNode.pNode = root;

        if(root.left != null)
            findInorderRecursive(root.left, searchNode, pNode);
    }
}
