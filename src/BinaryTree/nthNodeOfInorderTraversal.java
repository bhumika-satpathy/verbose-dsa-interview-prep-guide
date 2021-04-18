package BinaryTree;

public class nthNodeOfInorderTraversal {
    static int x = 0;
    void Solution(Node root, int n){
        if(root == null && n > 0)
            return;

        if(x <= n){
            Solution(root.left, n);
            x++;

            if(x == n)
                System.out.println(root.data);

            Solution(root.right, n);
        }
    }
}
