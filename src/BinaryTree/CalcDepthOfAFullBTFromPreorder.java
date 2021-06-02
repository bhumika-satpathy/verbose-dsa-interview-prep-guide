package BinaryTree;

// Calculate depth of a full Binary tree from Preorder
// ‘l’ denotes the leaf
//‘n’ denotes internal node
// Input  : nlnll
//Output : 2
public class CalcDepthOfAFullBTFromPreorder {

    int findDepth(String tree, int index, int n){
        if(index >= n || tree.charAt(index) == 'l')
            return 0;

        index++;
        // Height of the left subtree
        int left = findDepth(tree, index, n);

        index++;
        int right = findDepth(tree, index, n);

        return 1 + Math.max(left, right);
    }

    int Solution(String tree){
        if(tree.length() == 0)
            return 0;

        int index = 0, n = tree.length();
        return findDepth(tree, index, n);
    }
}
