package Heap;

// Note: If minHeap is used to extract root k times, then Time complex: O(n + klogn(n))

// Find the kth smallest element
// Finding basically (n-k)th element from the end
// Time complex: O(k + (n-k)log(k))
public class KthSmallestElement {
    class MaxHeap {
        int heapSize;
        int[] hArr;
        int capacity;

        MaxHeap(int[] arr, int cap){
            heapSize = 0;
            capacity = cap;
            hArr = arr;

            int i = (heapSize - 1)/2;
            while(i > 0){
                maxHeapify(i);
                i--;
            }
        }

        int left(int i){
            return (2*i + 1)/2;
        }

        int right(int i){
            return (2*i + 2)/2;
        }

        void maxHeapify(int i){
            int left = left(i);
            int right = right(i);
            int largest = i;

            if(left < capacity && hArr[largest] < hArr[left])
                largest = left;
            if(right < capacity && hArr[largest] < hArr[right])
                largest = right;

            if(largest != i){
                int tmp = hArr[i];
                hArr[i] = hArr[largest];
                hArr[largest] = tmp;

                maxHeapify(largest);
            }
        }

        void replaceMax(int key){
            hArr[0] = key;
            maxHeapify(0);
        }

        int getMax(){
            return hArr[0];
        }

        int kthSmallest(int[] arr, int n, int k){
            MaxHeap maxHeap = new MaxHeap(arr, k);
            for(int i = k; i < n; i++){
                if(arr[i] < maxHeap.getMax())
                    replaceMax(arr[i]);
            }

            return maxHeap.getMax();
        }
    }
}
