package BinaryTree;

// You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.
//Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
//As a reminder, any shorter prefix of a string is lexicographically smaller.
//    For example, "ab" is lexicographically smaller than "aba".
//A leaf of a node is a node that has no children.
// https://leetcode.com/problems/smallest-string-starting-from-leaf/
public class SmallestStringStartingFromLeaf {
    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    void dfs(TreeNode root, StringBuilder str) {
        if(root == null) {
            return;
        }
        str.append((char)('a' + root.val));

        if(root.left == null && root.right == null) {
            str.reverse();
            String s = str.toString();
            str.reverse();

            if(s.compareTo(ans) < 0) {
                ans = s;
            }
        }

        dfs(root.left, str);
        dfs(root.right, str);
        str.deleteCharAt(str.length() - 1);
    }
}
