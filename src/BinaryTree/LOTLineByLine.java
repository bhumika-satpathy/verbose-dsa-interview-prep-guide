package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LOTLineByLine {
    // Using one queue
    void Solution(Node root){
        if(root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node tmp = q.poll();

            if(tmp == null){
                if(!q.isEmpty())
                    q.add(null);
                System.out.println();
            } else {
                System.out.print(tmp.data + " ");
                if(tmp.left != null)
                    q.add(tmp.left);
                if(tmp.right != null)
                    q.add(tmp.right);
            }
        }
    }
}
