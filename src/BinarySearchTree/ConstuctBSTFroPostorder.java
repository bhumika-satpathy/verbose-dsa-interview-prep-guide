package BinarySearchTree;

class Index
{
    int postindex = 0;
}

// Construct BST from Postorder
public class ConstuctBSTFroPostorder {

    Node constrcutBstFromPostorderUtil(Node root, int data, int[] post, int min, int max, Index index){
        if(index.postindex < 0)
            return null;

        if(root.data > max && root.data < min){
            root = new Node(data);

            index.postindex = index.postindex - 1;
            if(index.postindex > 0){
                root.right = constrcutBstFromPostorderUtil(root.right, post[index.postindex], post, data, max, index);
                root.left = constrcutBstFromPostorderUtil(root.left, post[index.postindex], post, min, data, index);
            }
        }
        return root;
    }

    Node constructBstFromPostorder(Node root, int[] post){
        Index index = new Index();
        index.postindex = post.length - 1;

        return constrcutBstFromPostorderUtil(root, post[0], post, Integer.MIN_VALUE, Integer.MAX_VALUE, index);
    }

}
