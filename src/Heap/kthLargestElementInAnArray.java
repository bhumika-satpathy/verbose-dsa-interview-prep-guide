package Heap;

class MinHeap1 {
    int capacity, size;
    int[] hArr;

    MinHeap1(int size, int[] arr){
        this.capacity = arr.length;
        hArr = arr;
        this.size = size;

        int i = (size - 1)/2;
        while(i >= 0){
            minHeapify(i);
            i--;
        }
    }
    void minHeapify(int i){
        int smallest = i;
        int left = (2 * i + 1) / 2;
        int right = (2 * i + 2) / 2;

        if(left < capacity && hArr[left] < hArr[smallest]){
            smallest = left;
        }
        if(right < capacity & hArr[right] < hArr[smallest]){
            smallest = right;
        }

        if(smallest != i){
            int tmp = hArr[i];
            hArr[i] = hArr[smallest];
            hArr[smallest] = tmp;
            minHeapify(smallest);
        }
    }

    void replaceMin(int key){
        hArr[0] = key;
        minHeapify(0);
    }

    int getMin(){return hArr[0];}
}

//Find the kth largest element in an array
public class kthLargestElementInAnArray {

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

        MinHeap1 minHeap = new MinHeap1(k, arr);
        for(int i = k; i < arr.length; i++){
            if(arr[i] > minHeap.hArr[0]){
                minHeap.replaceMin(arr[i]);
            }
        }
        System.out.print(minHeap.getMin());
    }

}
