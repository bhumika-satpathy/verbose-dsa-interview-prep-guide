package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

// You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//Initially, all next pointers are set to NULL.
public class PopulatingNextPointersInEachNode {

    public Node1 connect(Node1 root) {
        if(root == null)
            return null;
        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            Node1 tmp = queue.poll();

            while(tmp != null){
                if(tmp.left != null)
                    queue.add(tmp.left);

                if(tmp.right != null)
                    queue.add(tmp.right);

                tmp.next = queue.peek();
                tmp = queue.poll();
            }

            if(!queue.isEmpty())
                queue.add(null);
        }

        return root;
    }

}
