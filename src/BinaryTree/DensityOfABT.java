package BinaryTree;

// Separate size class to be created because reference is to be passed to the getHeightAndSize function and no pass by value
class Size {
    int size = 0;
}

// Calculate Density of a Binary Tree
public class DensityOfABT {

    int getHeightAndSize(Node root, Size size){
        if(root == null)
            return 0;
        int leftHeight = getHeightAndSize(root, size);
        int rightHeight = getHeightAndSize(root, size);

        size.size++;
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    double Solution(Node root){
        Size sz = new Size();
        int height = getHeightAndSize(root, sz);

        return Math.ceil(sz.size/height);
    }
}
