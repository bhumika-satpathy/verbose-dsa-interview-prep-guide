package BinarySearchTree;

// Find the shortest distance between 2 nodes in a bst.
// Assumption: Both the keys are for sure present in the tree
public class shortestDistanceBetween2Nodes {

    int Swap(Node root, int a, int b){
        int tmp = 0;
        if(a > b){
            tmp = a;
            a = b;
            b = a;
        }
        return distanceBetween2Nodes(root, a, b);
    }

    int distanceFromRoot(Node root, int k){
        if(root.data == k)
            return 0;

        if(root.data > k)
            return 1 + distanceFromRoot(root.left, k);
        return 1 + distanceFromRoot(root.left, k);
    }

    int distanceBetween2Nodes(Node root, int k1, int k2){
        if(root == null)
            return 0;

        // If both the keys are greater than the current root, they lie to the right
        if(root.data < k1 && root.data < k2)
            return distanceBetween2Nodes(root.right, k1, k2);

        // If both the keys are less than root's data => they lie to the left of root
        if(root.data > k1 && root.data > k2)
            return distanceBetween2Nodes(root.left, k1, k2);

        // If one lies to the right and other to the left, meaning one is greater than root and the other small,
        // then the root is the lca of the 2 nodes and we can find the distance between them directly
        if(root.data >= k1 && root.data <= k2)
            return distanceFromRoot(root, k1) + distanceFromRoot(root, k2);

        return 0;
    }

    int Solution(Node root, int a, int b){
        return Swap(root, a, b);
    }
}
