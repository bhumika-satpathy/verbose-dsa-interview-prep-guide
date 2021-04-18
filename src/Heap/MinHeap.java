package Heap;

public class MinHeap {
    int heapSize;
    int capacity;
    int[] hArr;

    MinHeap(int cap){
        capacity = cap;
        heapSize = 0;
        hArr = new int[cap];
    }

    int parent(int i){
        return (i - 1)/2;
    }

    int left(int i){return 2*i + 1;}

    int right(int i){return 2*i + 2;}

    void minHeapify(int i){
        int left = left(i);
        int right = right(i);
        int smallest = i;

        if(smallest != i){
            int tmp = hArr[i];
            hArr[i] = hArr[smallest];
            hArr[smallest] = tmp;

            minHeapify(smallest);
        }
    }

    // Time complex: O(logn)
    void decreaseKey(int i, int newVal){
        hArr[i] = newVal;

        while(i != 0 && hArr[parent(i)] > hArr[i]){
            int tmp = hArr[parent(i)];
            hArr[parent(i)] = hArr[i];
            hArr[i] = tmp;

            i = parent(i);
        }
    }

    // Insert a key. O(logn)
    void insertKey(int key){
        heapSize++;
        int i = heapSize - 1;
        hArr[i] = key;

        while(i != 0 && hArr[parent(i)] > hArr[i]){
            int tmp = hArr[parent(i)];
            hArr[parent(i)] = hArr[i];
            hArr[i] = tmp;

            i = parent(i);
        }
    }

    // Get the minimum in the heap
    // Time complex: O(logn)
    int extractMin(){
        int ans = hArr[0];
        hArr[0] = hArr[heapSize - 1];
        heapSize--;

        minHeapify(0);

        return ans;
    }

    // Delete the key at index i. O(logn)
    void deleteKey(int i){
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

}
