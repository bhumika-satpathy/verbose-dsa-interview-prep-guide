package BinarySearchTree;

// Find the largest BST in a BT
public class LargestBst {

    class nodeInfo {
        int min;
        int max;
        int ans = 0;
        int size;

        boolean isBst;

        nodeInfo(int min, int max, int ans, int size, boolean isBst){
            this.min = min;
            this.max = max;
            this.ans = ans;
            this.size = size;
            this.isBst = isBst;
        }

        nodeInfo(){}
    }

    nodeInfo largestBst(Node root){
        if(root == null)
            return new nodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, true);
        if(root.left == null && root.right == null)
            return new nodeInfo(root.data, root.data, 1, 1, true);

        nodeInfo left = largestBst(root.left);
        nodeInfo right = largestBst(root.right);

        nodeInfo resultInfo = new nodeInfo();
        resultInfo.size = 1 + left.size + right.size;

        if(left.isBst && right.isBst && root.data < right.min && root.data > left.max){
            resultInfo.isBst = true;
            resultInfo.min = Math.min(root.data, Math.min(right.min, left.min));
            resultInfo.max = Math.max(root.data, Math.max(right.max, left.max));

            resultInfo.ans = resultInfo.size;
            return resultInfo;
        }

        resultInfo.isBst = false;
        resultInfo.ans = Math.max(left.ans, right.ans);

        return resultInfo;
    }
}
