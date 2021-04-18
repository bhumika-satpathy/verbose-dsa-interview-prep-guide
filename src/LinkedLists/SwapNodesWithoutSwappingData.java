package LinkedLists;

public class SwapNodesWithoutSwappingData {
    void Solution(Node head, int x, int y){
        Node nodeX = head, prevX = null, nodeY = head, prevY = null;

        // Base condition
        if(x == y)
            return;

        // Search for node x
        while(nodeX != null && nodeX.data != x){
            prevX = nodeX;
            nodeX = nodeX.next;
        }

        if(nodeX == null)
            return;

        // Search for node y
        while(nodeY != null && nodeY.data != y){
            prevY = nodeY;
            nodeY = nodeY.next;
        }

        if(nodeY == null)
            return;

        // If x != head
        if(prevX != null){
            prevX.next = nodeY;
        } else {
            head = nodeY;
        }

        // If y != head
        if(prevY != null){
            prevY.next = nodeX;
        } else {
            head = nodeX;
        }

        Node tmp = nodeX.next;
        nodeX.next = nodeY.next;
        nodeY.next = tmp;
    }
}
