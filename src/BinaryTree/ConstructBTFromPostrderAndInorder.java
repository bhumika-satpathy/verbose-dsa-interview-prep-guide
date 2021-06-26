package BinaryTree;

public class ConstructBTFromPostrderAndInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, postorder.length - 1, postorder, 0, inorder.length - 1, inorder);
    }

    TreeNode helper(int postStart, int postEnd, int[] postorder, int inStart, int inEnd, int[] inorder) {
        if(postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int iIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(root.val == inorder[i]) {
                iIndex = i;
                break;
            }
        }

        root.left = helper(postStart, postStart + iIndex - inStart - 1, postorder, inStart, iIndex - 1, inorder);
        root.right = helper(postEnd - (inEnd - iIndex), postEnd - 1, postorder, iIndex + 1, inEnd, inorder);

        return root;
    }
}
