package BinaryTree;

class NodeInorderSuccessor {
    int data;
    NodeInorderSuccessor left;
    NodeInorderSuccessor right;
    NodeInorderSuccessor next;

    NodeInorderSuccessor(int key){
        data = key;
    }
}

// SImilar method for inorder predecessor except that for predecessor, recursive call to left is to be made first
public class PopulateInorderSuccessorOfAllNodes {
    NodeInorderSuccessor next = null;
    void Solution(NodeInorderSuccessor root){
        if(root == null)
            return;
        Solution(root.right);
        root.next = next;
        next = root;

        Solution(root.left);
    }
}
