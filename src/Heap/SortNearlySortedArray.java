package Heap;

import java.util.Iterator;
import java.util.PriorityQueue;

// Sort a nearly sored array
// Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time.
// For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
// Time complex: O(k) + O((n-k) * log(k))
// Approach: Fill in initial k + 1 elements because the very first element in the sorted array would be at max k distance from its 0th index. This way follow the same for the rest of the elements
public class SortNearlySortedArray {

    int[] Solution(int[] arr, int size, int k){
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for(int i = 0; i < k + 1; i++){
            pQ.add(arr[i]);
        }

        int index = 0;
        for(int i = k + 1; i < size;i++){
            arr[index++] = pQ.poll();
            pQ.add(arr[i]);
        }

        Iterator<Integer> it = pQ.iterator();
        while(it.hasNext()){
            arr[index++] = it.next();
        }

        return arr;
    }

}
