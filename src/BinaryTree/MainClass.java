package BinaryTree;

class Node {
    int data;
    Node left, right;

    Node(int key){
        data = key;
        left = null;
        right = null;
    }

    Node(){
        left = null;
        right = null;
    }
}

public class MainClass {
    public static void main(String[] args){
        Node root = null;
//        InsertionInABinaryTree insert = new InsertionInABinaryTree();
//        root = insert.Solution(root, 1);
//        root = insert.Solution(root, 2);
//        root = insert.Solution(root, 3);
//        root = insert.Solution(root, 4);
//        root = insert.Solution(root, 5);
//        root = insert.Solution(root, 6);
//        root = insert.Solution(root, 7);
//        root = insert.Solution(root, 8);
//        root = insert.Solution(root, 9);

//        DeletionInABinaryTree delete = new DeletionInABinaryTree();
//        root = delete.Solution(root, 2);
//        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
//        levelOrderTraversal.Solution(root);

//        LOTInSpiralForm lotInSpiralForm = new LOTInSpiralForm();
//        lotInSpiralForm.Solution(root);

//        LOTLineByLine lotLineByLine = new LOTLineByLine();
//        lotLineByLine.Solution(root);

//        LOTWithDirectionChange lotWithDirectionChange = new LOTWithDirectionChange();
////        lotWithDirectionChange.Solution(root);
//        lotWithDirectionChange.Solution2(root);

//        ReverseLOT reverseLot = new ReverseLOT();
//        reverseLot.Solution(root);

//        nthNodeOfInorderTraversal nthNode = new nthNodeOfInorderTraversal();
//        nthNode.Solution(root, 4);

//        root = new Node(20);
//        root.left = new Node(8);
//        root.left.left = new Node(4);
//        root.left.right = new Node(12);
//        root.left.right.left = new Node(10);
//        root.left.right.right = new Node(14);
//        root.right = new Node(22);
//        root.right.right = new Node(25);

//        BoundaryTraversalOfABT boundaryTraversal = new BoundaryTraversalOfABT();
//        boundaryTraversal.Solution(root);

//        LCA lca = new LCA();
//        lca.Solution3();

//        KthAncestorNodeInABT kthANcestor = new KthAncestorNodeInABT();
//        kthANcestor.Solution();

//        PrintAncestorsOfAGivenNode printAncestorsOfAGivenNode = new PrintAncestorsOfAGivenNode();
//        printAncestorsOfAGivenNode.Solution();

//        PrintPathFromRootToAGivenNode printPathFromRootToAGivenNode = new PrintPathFromRootToAGivenNode();
//        printPathFromRootToAGivenNode.Solution();

//        PrintCommonNodesOnPathFromRoot printCommonNodesOnPathFromRoot = new PrintCommonNodesOnPathFromRoot();
//        printCommonNodesOnPathFromRoot.Solution();

        DeleteNodesWithTargetX deleteNodesWithTargetX = new DeleteNodesWithTargetX();
        deleteNodesWithTargetX.Solution();
    }
}
