package BinarySearchTree;

class Count {
    int cnt = 0;
}

// Get the kth largest element
public class kthLargestElement {

    void kthLargest(Node root, int k, Count c){

        if(root == null || c.cnt >= k)
            return;

        kthLargest(root.right, k, c);
        c.cnt++;

        if(c.cnt == k){
            System.out.println(k + "th largest element is " + root.data);
            return;
        }

        kthLargest(root.left, k, c);
    }

    void Solution(){
        InsertNodeInABST insertNodeInABST = new InsertNodeInABST();
        Node root = null;
        root = insertNodeInABST.InsertANode(root, 50);
        root = insertNodeInABST.InsertANode(root, 30);
        root = insertNodeInABST.InsertANode(root, 20);
        root = insertNodeInABST.InsertANode(root, 40);
        root = insertNodeInABST.InsertANode(root, 70);
        root = insertNodeInABST.InsertANode(root, 60);
        root = insertNodeInABST.InsertANode(root, 80);

        InorderTraversal inorderTraversal = new InorderTraversal();
        inorderTraversal.inorderTraversal(root);

        Count c = new Count();

        kthLargest(root, 3, c);
    }

}
