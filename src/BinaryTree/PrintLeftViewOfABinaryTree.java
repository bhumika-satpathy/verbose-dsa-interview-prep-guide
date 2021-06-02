package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftViewOfABinaryTree {
    // Using Level Order Traversal
    void usingLOT(Node root){
        if(root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            Node tmp = queue.poll();

            for(int i = 1; i <= n; i++){
                if(i == 1)
                    System.out.println(tmp.data);

                if(tmp.left != null)
                    queue.add(tmp.left);
                if(tmp.right != null)
                    queue.add(tmp.right);
                tmp = queue.poll();
            }
        }
    }

    // Using recursion
    static int maxLevel = 0;

    void printLeftViewRecursion(Node root, int lvl){
        if(root == null)
            return;

        if(maxLevel < lvl){
            System.out.println(root.data);
            maxLevel = lvl;
        }

        printLeftViewRecursion(root.left, lvl + 1);
        printLeftViewRecursion(root.right, lvl + 1);
    }
}
