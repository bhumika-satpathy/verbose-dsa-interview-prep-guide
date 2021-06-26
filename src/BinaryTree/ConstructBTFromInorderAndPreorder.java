package BinaryTree;

// Construct a binary tree from inorder and preorder traversals
public class ConstructBTFromInorderAndPreorder {
    TreeNode buildTree(int[] inorder, int[] preorder) {
        int inStart = 0, inEnd = inorder.length - 1, preStart = 0;
        return helper(preStart, preorder, inStart, inEnd, inorder);
    }

    TreeNode helper(int preStart, int[] preorder, int inStart, int inEnd, int[] inorder) {
        if(preStart >= preorder.length || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = 0;

        for(int i = inStart; i <= inEnd; i++) {
            if(root.val == inorder[i]) {
                inIndex = i;
                break;
            }
        }

        // Use of the inIndex variable is to set the offset for the right subtree.
        // While moving towards the left, the left subtree to be used would lie towards the left of the root in the inorder array and hence we are using inIndex + 1
        root.left = helper(preStart + 1, preorder, inStart, inIndex - 1, inorder);
        // In both preorder and inorder, the first two traversals include left and root traversal (In case of inorder, its left root right and in preorder, root, left right)
        // Hence while moving towards the right, the inIndex(denoting index of root in inorder[]) - the inorder start (inStart) denotes the root + left portion of the subtree
        // Hence root index - in start + 1 would essentially give us the number of elements to the left subtree. Add one to it and you would get the right index.
        root.right = helper(preStart + inIndex - inStart + 1, preorder, inIndex + 1, inEnd, inorder);

        return root;
    }
}
