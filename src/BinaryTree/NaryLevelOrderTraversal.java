package BinaryTree;

import java.util.*;

// Given an n-ary tree, return the level order traversal of its nodes' values.
//
//Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

class NodeNary {
    public int val;
    public List<NodeNary> children;

    public NodeNary() {}

    public NodeNary(int _val) {
        val = _val;
    }

    public NodeNary(int _val, List<NodeNary> _children) {
        val = _val;
        children = _children;
    }
};

public class NaryLevelOrderTraversal {
    public List<List<Integer>> levelOrder(NodeNary root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        List<Integer> level;
        Queue<NodeNary> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            level = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                NodeNary node = q.poll();
                q.addAll(node.children);
                level.add(node.val);
            }

            res.add(new ArrayList<>(level));
        }

        return res;
    }
}
