package BinaryTree;

/*
Given a binary tree, delete a node from it by making sure that tree shrinks from the bottom (i.e. the deleted node is replaced by bottom most and rightmost node).
This different from BST deletion. Here we do not have any order among elements, so we replace with last element.
 */

import java.util.LinkedList;
import java.util.Queue;

public class DeletionInABinaryTree {

    void deleteDeepestNode(Node root, Node delNode){
        if(root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node tmp = queue.poll();

            if(tmp.right != null){
                if(tmp.right == delNode){
                    tmp.right = null;
                    return;
                } else queue.add(tmp.right);
            }
            if(tmp.left != null){
                if(tmp.left == delNode){
                    tmp.left = null;
                    return;
                } else queue.add(tmp.left);
            }
        }
    }

    Node Solution(Node root, int key){

        if(root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node tmp = null;
        Node keyNode = null;

        while(!queue.isEmpty()){
            tmp = queue.poll();

            if(tmp.data == key){
                keyNode = tmp;
            }

            if(tmp.left != null){
                queue.add(tmp.left);
            }
            if(tmp.right != null)
                queue.add(tmp.right);
        }

        if(keyNode != null){
            int k = tmp.data;
            deleteDeepestNode(root, tmp);
            keyNode.data = k;
        }

        return root;
    }
}
