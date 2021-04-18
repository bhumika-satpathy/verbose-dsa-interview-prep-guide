package BinaryTree;

import java.util.Stack;

// Print Level Order Traversal In Spiral Form
public class LOTInSpiralForm {
    // Using 2 stacks
    // Time complex: O(n)
    void Solution(Node root){
        if(root == null)
            return;

        // s1 stores nodes to print them from right to left and s2 from left to right
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                Node tmp = s1.pop();
                System.out.print(tmp.data + " ");

                if(tmp.right != null)
                    s2.push(tmp.right);
                if(tmp.left != null)
                    s2.push(tmp.left);
            }

            while(!s2.isEmpty()){
                Node tmp = s2.pop();
                System.out.print(tmp.data + " ");

                if(tmp.left != null)
                    s1.push(tmp.left);
                if(tmp.right != null)
                    s1.push(tmp.right);
            }
        }
    }
}
