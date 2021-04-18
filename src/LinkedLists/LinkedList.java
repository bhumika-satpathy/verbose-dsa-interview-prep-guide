package LinkedLists;

import javafx.scene.transform.Rotate;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int val){
        data = val;
        next = null;
    }
}

public class LinkedList {
//    Node head;

    // Insert new node at the beginning
    Node insertionAtTheBeginning(Node head, int val){
        if(head == null){
            head = new Node(val);
            return head;
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;

        return head;
    }

    // Insert new node after a node having value val
    void insertAfterANode(int val, Node head, int newNodeVal){
        if(head == null){
            System.out.println("No nodes present!");
            return;
        }
        while(head != null && head.data != val){
            head = head.next;
        }
        if(head != null && head.data == val){
            head.next = new Node(newNodeVal);
        }
    }

    // Insert a node at the end
    void insertAtTheEnd(Node head, int val){
        while(head.next != null)
            head = head.next;
        head.next = new Node(val);
    }

    void insertNodes(Node head, int numOfNodes){
        int val;
        Node tmp = head;
        while(numOfNodes > 0){
            Scanner sc = new Scanner(System.in);
            val = sc.nextInt();
            if(head == null){
                head = new Node(val);
                numOfNodes--;
                continue;
            }
            Node newNode = new Node(val);
            tmp.next  = newNode;
            tmp = newNode;
            numOfNodes--;
        }
    }

    void display(Node head){
        if(head == null){
            System.out.println();
            return;
        }
        System.out.print(head.data + " ");
        display(head.next);
    }

    public static void main(String[] args){
        Node head = new Node(1);
        LinkedList ll = new LinkedList();

        ll.insertNodes(head, 7);
        ll.display(head);

//        head = ll.insertionAtTheBeginning(head, 9);
//        ll.display(head);
//
//        ll.insertAfterANode(10, head, 20);
//        ll.display(head);
//
//        ll.insertAtTheEnd(head, 100);
//        ll.display(head);

//        DeleteNode deleteNode = new DeleteNode();
//        deleteNode.Solution(head, 1);
//        ll.display(head);

//        DeleteGivenPosition deleteGivenPosition = new DeleteGivenPosition();
//        head = deleteGivenPosition.Solution(head, 2);
//        ll.display(head);

//        LengthOfLinkedList lengthOfLL = new LengthOfLinkedList();
//        System.out.println(lengthOfLL.IterativeSolution(head));
//        System.out.println(lengthOfLL.RecursiveSolution(head));

//        SearchAnElement search = new SearchAnElement();
//        System.out.println(search.IterativeSolution(head, 2));
//        System.out.println(search.RecursiveSolution(head, 6));

//        NthNodeInLinkedList nthNode = new NthNodeInLinkedList();
//        System.out.println(nthNode.IterativeSolution(head, 2).data);
//        System.out.println(nthNode.RecursiveSolution(head, 6, 1).data);

//        NthNodeFromTheEnd nthNodeFromEnd = new NthNodeFromTheEnd();
//        System.out.println(nthNodeFromEnd.Solution(head, 2).data);

//        MiddleOfALL middle = new MiddleOfALL();
//        System.out.println(middle.Solution(head).data);

//        NumberOfTimesGivenIntOccurs number = new NumberOfTimesGivenIntOccurs();
//        System.out.println(number.RecursiveSolution(head, 0));

//        IsPalindrome palindrome = new IsPalindrome();
//        System.out.println(palindrome.Solution(head));

//        MergeSortLL mergeSort = new MergeSortLL();
//        mergeSort.Solution(head);
//        ll.display(head);

//        RemoveDuplicatesFromAnUnsortedLL removeNodes = new RemoveDuplicatesFromAnUnsortedLL();
//        head = removeNodes.Solution(head);
//        ll.display(head);

//        RemoveDuplicatesFromAnUnsortedLL removeNodes = new RemoveDuplicatesFromAnUnsortedLL();
//        removeNodes.Solution2(head);
//        ll.display(head);

//        SwapNodesWithoutSwappingData swapNodes = new SwapNodesWithoutSwappingData();
//        swapNodes.Solution(head, 2, 3);
//        ll.display(head);

//        PairWiseSwapNodes pairWiseSwap = new PairWiseSwapNodes();
//        head = pairWiseSwap.Solution(head);
//        ll.display(head);

//        MoveLastElementToFirst moveToFirst = new MoveLastElementToFirst();
//        head = moveToFirst.Solution(head);
//        ll.display(head);

//        SegregateEvenOddNodes segregateEvenOddNodes = new SegregateEvenOddNodes();
//        head = segregateEvenOddNodes.Solution(head);
//        ll.display(head);

//        ReverseALL reverse = new ReverseALL();
//        head = reverse.Solution(head);
//        ll.display(head);

//        PrintReverseWithoutReversing reversePrint = new PrintReverseWithoutReversing();
//        reversePrint.Solution(head);

//        MakeMidNodeHead makeMidHead = new MakeMidNodeHead();
//        head = makeMidHead.Solution(head);
//        ll.display(head);

//        DeleteAlternateNodes deleteAlternateNodes = new DeleteAlternateNodes();
//        deleteAlternateNodes.IterativeSolution(head);
//        ll.display(head);
//        deleteAlternateNodes.RecursiveSolution(head);
//        ll.display(head);

//        ReverseLLUsing2Pointers reverse = new ReverseLLUsing2Pointers();
//        head = reverse.Solution(head);
//        ll.display(head);

//        Merge2SortedLLSuchThatMergedListInReverseOrder mergeSorted = new Merge2SortedLLSuchThatMergedListInReverseOrder();
//        Node res = mergeSorted.Solution(head, head);
//        ll.display(res);

//        ReverseLLInGroupsOfGivenSize reverse = new ReverseLLInGroupsOfGivenSize();
//        head = reverse.Solution(head, 3);
//        ll.display(head);

//        ReverseAlternatekNodes reverse = new ReverseAlternatekNodes();
//        head = reverse.Solution(head, 3, true);
//        ll.display(head);

//        RotateALL rotate = new RotateALL();
//        head = rotate.Solution(head, 3);
//        ll.display(head);

        DeleteNodesWithGreaterValueOnRight deleteNodes = new DeleteNodesWithGreaterValueOnRight();
        head = deleteNodes.Solution(head);
        ll.display(head);
    }
}