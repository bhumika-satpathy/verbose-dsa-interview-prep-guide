package BinarySearchTree;

// Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
//
//You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
//
//We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor.
// You should return the pointer to the smallest element of the linked list.
// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
public class ConvertBSTToSortedDoublyLL {
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        // Base condition
        if(root == null) {
            return root;
        }

        accumulateLeftRightNodes(root);

        last.right = first;
        first.left = last;

        return first;
    }

    void accumulateLeftRightNodes(Node root) {
        if(root == null) {
            return;
        }

        accumulateLeftRightNodes(root.left);
        if(last == null) {
            first = root;
        } else {
            last.right = root;
            root.left = last;
        }
        last = root;
        accumulateLeftRightNodes(root.right);
    }
}
