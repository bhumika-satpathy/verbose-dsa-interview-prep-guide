package BinaryTree;

import java.util.HashSet;

public class LCA {
    // ---------- Solution 1 -------------------------------------------------------------------------
    Node findLCA2(Node root, int n1, int n2){
        if(root == null)
            return null;

        Node tmp = null;

        if(root.data == n1){
            tmp = root;
            v1 = true;
        }
        if(root.data == n2){
            tmp = root;
            v2 = true;
        }

        Node leftLca = findLCA2(root.left, n1, n2);
        Node rightLca = findLCA2(root.right, n1, n2);

        if(tmp != null)
            return tmp;

        if(leftLca != null && rightLca != null)
            return root;

        return leftLca != null ? leftLca : rightLca;
    }
    // Assuming both the numbers do not exist initially
    boolean v1 = false;
    boolean v2 = false;
    // Covers all cases including validating if both numbers are present or not
    Node Solution1(Node root, int n1, int n2){
        if(root == null)
            return null;

        Node lca = findLCA2(root, n1, n2);

        if(v1 == false || v2 == false){
            System.out.print("Either of the two numbers are absent.");
            return null;
        }

        return lca;
    }

    // -------------- Solution 2 -----------------------------------------------------------------------

    NodeLca insert(NodeLca root, int key){
        if(root == null)
            return new NodeLca(key);

        if(root.data > key){
            root.left = insert(root.left, key);
            root.left.parent = root;
        } else if(root.data < key){
            root.right = insert(root.right, key);
            root.right.parent = root;
        }

        return root;
    }

    NodeLca search(NodeLca root, int key){
        if(root == null)
            return null;

        if(root.data == key)
            return root;

        NodeLca left = search(root.left, key);
        NodeLca right = search(root.right, key);

        return left != null ? left : right;
    }

    NodeLca fidLca(NodeLca root, int k1, int k2){
        if(root == null)
            return null;

        HashSet<NodeLca> parents = new HashSet<>();
        NodeLca n1 = search(root, k1);
        NodeLca n2 = search(root, k2);

        while(n1 != null){
            parents.add(n1);
            n1 = n1.parent;
        }

        while(n2 != null){
            if(parents.contains(n2))
                return n2;
            n2 = n2.parent;
        }

        return null;
    }

    void Solution2(){
        NodeLca root = null;
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);

        NodeLca ans = fidLca(root, 20, 14);
        System.out.print(ans.data);
    }

    // -------------- Solution 2.1 -------------------------------------

    // Find depth of a node from the root
    int depth(NodeLca root, NodeLca node){
        if(root == null)
            return 0;

        int d = -1;
        while(node != null){
            ++d;
            node = node.parent;
        }

        return d;
    }

    NodeLca findLca3(NodeLca root, int k1, int k2){
        if(root == null)
            return null;

        NodeLca n1 = search(root, k1);
        NodeLca n2 = search(root, k2);

        int diff = depth(root, n1) - depth(root, n2);
        if(diff < 0){
            NodeLca tmp = n1;
            n1 = n2;
            n2 = tmp;
            diff = -diff;
        }

        while (diff-- > 0)
            n1 = n1.parent;

        while(n1 != null && n2 != null){
            if(n1 == n2)
                return n1;
            n1 = n1.parent;
            n2 = n2.parent;
        }

        return null;
    }

    // Doesn't use extra space
    void Solution3(){
        NodeLca root = null;
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);

        NodeLca ans = findLca3(root, 10, 14);
        System.out.print(ans.data);
    }
}

class NodeLca {
    int data;
    NodeLca left, right, parent;

    NodeLca(int key){
        data = key;
        left = null;
        right = null;
        parent = null;
    }
}