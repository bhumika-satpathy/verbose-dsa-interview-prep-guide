package Heap;

class MinHeapNode {
    // The current element stored in the node
    int element;
    // Index of the array from the k arrays
    int i;
    // Index of the next element from the array, arr[i]
    int j;

    MinHeapNode(int ele, int i, int j){
        element = ele;
        this.i = i;
        this.j = j;
    }
}

class MinHeapForSorting {
    MinHeapNode[] hArr;
    int heapSize;

    MinHeapForSorting(MinHeapNode[] arr, int cap){
        hArr = arr;
        heapSize = cap;

        int i = (heapSize - 1)/2;
        while(i >= 0){
            minHeapify(i);
            i--;
        }
    }

    int left(int i){
        return (2 * i + 1)/2;
    }

    int right(int i){
        return (2*i + 2)/2;
    }

    void minHeapify(int i){
        int left = left(i);
        int right = right(i);
        int smallest = i;

        if(left < heapSize && hArr[left].element < hArr[right].element)
            smallest = left;
        if(right < heapSize && hArr[right].element < hArr[smallest].element)
            smallest = right;

        if(smallest != i){
            MinHeapNode tmp = hArr[i];
            hArr[i] = hArr[smallest];
            hArr[smallest] = tmp;

            minHeapify(smallest);
        }
    }

    MinHeapNode getMin(){
        return hArr[0];
    }

    void replaceMin(MinHeapNode root){
        hArr[0] = root;
        minHeapify(0);
    }
}

// Given k sorted arrays, sort them and return a sorted array
public class MergeKSortedArrays {

    int[] mergeKSortedArrays(int[][]arr, int k){
        MinHeapNode[] nodes = new MinHeapNode[k];
        int resultSize = 0;

        for(int i = 0; i < k; i++){
            nodes[i] = new MinHeapNode(arr[i][0], i, 1);
            resultSize += arr[i].length;
        }

        int[] result = new int[resultSize];
        MinHeapForSorting minHeap = new MinHeapForSorting(nodes, k);

        for(int i = 0; i < resultSize; i++){
            MinHeapNode node = minHeap.getMin();
            result[i] = node.element;

            if(node.j < arr[node.i].length)
                node.element = arr[node.i][node.j++];
            // If the next element doesn't exist => arr end has been reached
            else  node.element = Integer.MAX_VALUE;
            minHeap.replaceMin(node);
        }
        return result;
    }

    void Solution(){
        int[][] arr= {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};

        int k = arr.length;
        int[] res = mergeKSortedArrays(arr, k);
    }
}
