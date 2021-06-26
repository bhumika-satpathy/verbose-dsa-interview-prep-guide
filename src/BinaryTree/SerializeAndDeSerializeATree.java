package BinaryTree;

import java.util.*;

public class SerializeAndDeSerializeATree {
    String serializeToString(TreeNode root, String str) {
        if(root == null) {
            str += "null" + ",";
            return str;
        }

        str += String.valueOf(root.val) + ",";
        str = serializeToString(root.left, str);
        str = serializeToString(root.right, str);

        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String str = "";
        str = serializeToString(root, str);

        return str;
    }

    TreeNode desearilizeToTree(List<String> list) {
        if(list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = desearilizeToTree(list);
        root.right = desearilizeToTree(list);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_strm = data.split(",");
        List<String> dataList = new ArrayList<>(Arrays.asList(data_strm));

        return desearilizeToTree(dataList);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
