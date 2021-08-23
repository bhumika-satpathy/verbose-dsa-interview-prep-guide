package BinaryTree;

import java.util.*;

// Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
//
//Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
// https://leetcode.com/problems/n-ary-tree-postorder-traversal/
public class NaryPostOrderTraversal {
    public List<Integer> postorder(NodeNary root) {
        LinkedList<NodeNary> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if(root == null) {
            return output;
        }

        stack.add(root);

        while(!stack.isEmpty()) {
            NodeNary node = stack.pollLast();
            output.addFirst(node.val);

            for(NodeNary child: node.children) {
                if(child != null) {
                    stack.add(child);
                }
            }
        }

        return output;
    }
}
