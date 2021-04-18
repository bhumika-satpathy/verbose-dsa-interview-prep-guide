package BinarySearch;

// Fins the maximum in first increasing and then decreasing element
public class PeakElementInAPyramid {

    int findMax(int[] arr, int low, int high){
        if(low == high)
            return arr[low];

        if(low + 1 == high){
            if(arr[low] > arr[high])
                return arr[low];
            return arr[high];
        }

        int mid = low + (high - low)/2;

        if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
            return arr[mid];

        if(arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1])
            return findMax(arr, mid + 1, high);
        return findMax(arr, low, mid - 1);
    }

}
