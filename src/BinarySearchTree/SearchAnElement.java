package BinarySearchTree;

// Search an Element in a Binary Tree
public class SearchAnElement {
    Node search(Node root, int searchKey){
        if(root == null || root.data == searchKey)
            return root;

        if(searchKey < root.data)
            return search(root.left, searchKey);

        return search(root.right, searchKey);
    }
}
