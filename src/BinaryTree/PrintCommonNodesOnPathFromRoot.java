package BinaryTree;

import java.util.Stack;

// Print common nodes on path from root
public class PrintCommonNodesOnPathFromRoot {

    static boolean v1 = false, v2 = false;

    Node findLca(Node root, int k1, int k2){
        if(root == null)
            return null;

        Node tmp = null;

        if(root.data == k1){
            v1 = true;
            tmp = root;
        }

        if(root.data == k2){
            v2 = true;
            tmp = root;
        }

        Node left = findLca(root.left, k1, k2);
        Node right = findLca(root.right, k1, k2);

        if(tmp != null)
            return tmp;

        if(left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    Stack<Node> stk = new Stack<>();

    Node getAncestors(Node root, Node searchNode){
        if(root == null)
            return null;

        if(root == searchNode){
            stk.push(root);
            return root;
        }

        Node left = getAncestors(root.left, searchNode);
        Node right = getAncestors(root.right, searchNode);

        if(left != null || right != null){
            stk.push(root);
            return root;
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

        Node lca = findLca(root, 4, 5);
        getAncestors(root, lca);

        while(!stk.isEmpty()){
            System.out.print(stk.pop().data + " ");
        }
    }

}
