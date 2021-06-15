package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// Find the kth largest element in an array
public class kthLargestElementInAnArray {

    class MinHeap {
        int heapSize, cap;
        int[] hArr;

        // Creating a minimum heap of size k here because we want to limit the heap size to k and keep only the largest k elements ordered from smallest to largest
        // i.e., out of the k largest elements, the minheap stores the 1st element of the k elements first, in the hArr[0] due to which we are able to extract the minimum
        MinHeap(int[] arr, int k) {
            heapSize = k;
            cap = k;
            hArr = Arrays.copyOfRange(arr, 0, k);

            int i = (k - 1) / 2;
            while(i >= 0) {
                minHeapify(i);
                i--;
            }
        }

        void minHeapify(int i) {
            int smallest = i;
            int left = (2 * i + 1);
            int right = (2 * i + 2);

            if(left < cap && hArr[left] < hArr[smallest]) {
                smallest = left;
            }
            if(right < cap && hArr[right] < hArr[smallest]) {
                smallest = right;
            }

            if(smallest != i) {
                int tmp = hArr[i];
                hArr[i] = hArr[smallest];
                hArr[smallest] = tmp;

                minHeapify(smallest);
            }
        }

        int getMin() {
            return hArr[0];
        }

        void replaceMin(int key) {
            hArr[0] = key;
            minHeapify(0);
        }
    }
    public int findKthLargest(int[] nums, int k) {
        MinHeap minHeap = new MinHeap(nums, k);

        for(int i = k; i < nums.length; i++) {
            if(nums[i] > minHeap.getMin()) {
                minHeap.replaceMin(nums[i]);
            }
        }

        return minHeap.getMin();
    }

    // ------------------------------------------------ Solution 2 ---------------------------------------------------
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

//         for(int i = 0; i < k; i++)
//             pQ.add(nums[i]);

//         for(int i = k; i < nums.length; i++)
//             if(nums[i] > pQ.peek()){
//                 pQ.poll();
//                 pQ.add(nums[i]);
//             }

        for(int i = 0; i < nums.length; i++){
            pQ.add(nums[i]);
            if(i >= k){
                pQ.poll();
            }
        }

        return pQ.peek();
    }

}
