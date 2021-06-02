package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertionInABinaryTree {
    Node Solution(Node root, int key){

        if(root == null){
            root = new Node(key);
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node tmp = queue.poll();

            if(tmp.left == null){
                tmp.left = new Node(key);
                break;
            } else
                queue.add(tmp.left);
            if(tmp.right == null){
                tmp.right = new Node(key);
                break;
            } else
                queue.add(tmp.right);
        }

        return root;
    }
}