package BinarySearchTree;

public class ConstructBSTFromGivenPreorder {

    Node constructBSTUtil(Node root, int key){
        if(root == null)
            return new Node(key);

        if(root.data > key)
            root.left = constructBSTUtil(root.left, key);
        if(root.data < key)
            root.right = constructBSTUtil(root.right, key);

        return root;
    }

    Node constructBST(int[] pre){
        Node root = null;
        for(int i = 0; i < pre.length; i++)
            constructBSTUtil(root, pre[i]);

        return root;
    }

    void Solution(){

    }
}
