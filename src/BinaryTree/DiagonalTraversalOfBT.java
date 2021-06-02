package BinaryTree;

import java.util.*;

// Diagonal traversal of a binary tree
public class DiagonalTraversalOfBT {

    void diagonalPrint(Node root, int d, HashMap<Integer, List<Integer>> diagonal){
        if(root == null)
            return;

        List<Integer> k = diagonal.get(d);

        if(k == null)
            k = new ArrayList<>();
        k.add(root.data);
        diagonal.put(d, k);

        diagonalPrint(root.left, d + 1, diagonal);
        diagonalPrint(root.right, d, diagonal);
    }

    void Solution(Node root){
        if(root == null)
            return;

        HashMap<Integer, List<Integer>> diagonalWiseElements = new HashMap<>();
        diagonalPrint(root, 0, diagonalWiseElements);

        for(Map.Entry<Integer, List<Integer>> entry: diagonalWiseElements.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    // Iteratively print the diagonal of a BT
    void IterativelyPrintDiagonal(Node root){
        if(root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node tmp = q.poll();
            while(tmp != null){
                System.out.print(tmp.data + " ");
                if(tmp.left != null)
                    q.add(tmp.left);
                tmp = tmp.right;
            }
        }
    }
}
