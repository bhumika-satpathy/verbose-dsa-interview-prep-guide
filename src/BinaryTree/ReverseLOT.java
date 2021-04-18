package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLOT {
    void Solution(Node root){
        if(root == null)
            return;

        Stack<Node> stk = new Stack<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node tmp = q.poll();
            stk.push(tmp);
            if(tmp.right != null)
                q.add(tmp.right);
            if(tmp.left != null)
                q.add(tmp.left);
        }

        while(!stk.isEmpty()){
            Node tmp = stk.pop();
            System.out.print(tmp.data + " ");
        }
    }
}
