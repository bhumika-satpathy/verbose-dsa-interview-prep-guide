package Heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KLargestElementsInAnArray {

    void kLargestElements(int[] arr, int size, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Alternate method
//        for(int i = 0; i < arr.length; i++){
//            minHeap.add(arr[i]);
//            if(i >= k){
//                minHeap.poll();
//            }
//        }

        for(int i = 0; i < k; i++)
            minHeap.add(arr[i]);

        for(int i = k; i < size; i++){
            if(minHeap.peek() > arr[i]){
                continue;
            } else {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        Iterator<Integer> i = minHeap.iterator();
        while(i.hasNext()){
            int x = i.next();
            System.out.print(x + " ");
        }
    }
}