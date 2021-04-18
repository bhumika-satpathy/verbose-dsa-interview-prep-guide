package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Level order traversal with direction change after every two levels
public class LOTWithDirectionChange {

    int getHeight(Node root){
        if(root == null)
            return 0;
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);

        if(lHeight > rHeight)
            return 1 + lHeight;
        else return 1 + rHeight;
    }

    void printLOT(Node root, int lvl, boolean ltr){
        if(root == null)
            return;
        if(lvl == 1)
            System.out.print(root.data + " ");
        else {
            if(ltr){
                printLOT(root.left, lvl - 1, ltr);
                printLOT(root.right, lvl - 1, ltr);
            } else {
                printLOT(root.right, lvl - 1, ltr);
                printLOT(root.left, lvl - 1, ltr);
            }
        }
    }

    // Using recursion
    // Time complex: O(n2) -> worst in case of skewed trees
    void Solution(Node root){
        if(root == null)
            return;

        int height = getHeight(root), cnt = 0;
        // left to right
        boolean ltr = true;
        for(int i = 1; i <= height; i++){
            printLOT(root, i, ltr);
            if(i % 2 == 0)
                ltr = !ltr;
        }
    }

    // Using queues and stacks, without using recursion
    void Solution2(Node root){
        if(root == null)
            return;

        if(root.left == null && root.right == null){
            System.out.print(root.data + " ");
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Stack<Node> stk = new Stack<>();

        // To track the direction change
        int ct = 0;
        boolean rightToLeft = false;

        while(!q.isEmpty()){
            ct++;
            int n = q.size();

            for(int i = 0; i < n ; i++){
                Node tmp = q.poll();

                if(rightToLeft == false)
                    System.out.print(tmp.data + " ");

                else stk.push(tmp);

                if(tmp.left != null)
                    q.add(tmp.left);
                if(tmp.right != null)
                    q.add(tmp.right);
            }

            if(rightToLeft){
                while(!stk.isEmpty()){
                    Node tmp = stk.pop();

                    System.out.print(tmp.data + " ");
                }
            }

            if(ct == 2){
                ct = 0;
                rightToLeft = !rightToLeft;
            }
        }
    }
}
