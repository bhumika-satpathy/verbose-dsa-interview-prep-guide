package BinaryTree;

import java.util.*;

// Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
//
//Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
// https://leetcode.com/problems/n-ary-tree-preorder-traversal/
public class NaryPreorderTraversal {
    public List<Integer> preorder(NodeNary root) {
        LinkedList<NodeNary> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if(root == null) {
            return output;
        }

        stack.add(root);

        while(!stack.isEmpty()) {
            NodeNary node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for(NodeNary child: node.children) {
                if(child != null) {
                    stack.add(child);
                }
            }
        }

        return output;
    }
}
