package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Count pairs from two BSTs whose sum is equal to a given value x
public class CountPairs {
    int countPairs(Node root1, Node root2, int sum){
        int cntPairs = 0;

        Stack<Node> stk1 = new Stack<>();
        Stack<Node> stk2 = new Stack<>();

        while(true){

            while(root1 != null){
                stk1.push(root1);
                root1 = root1.left;
            }

            while(root2 != null){
                stk2.add(root2);
                root2 = root2.right;
            }

            if(stk1.isEmpty() || stk2.isEmpty())
                break;

            int n1 = stk1.peek().data, n2 = stk2.peek().data;

            if(n1 + n2 == sum){
                cntPairs++;
                root1 = stk1.pop().right;
                root2 = stk2.pop().left;
            } else if(n1 + n2 < sum){
                root1 = stk1.pop().right;
            } else root2 = stk2.pop().left;
        }
        return cntPairs;
    }

}
