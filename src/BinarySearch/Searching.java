package BinarySearch;

import java.util.Arrays;

public class Searching {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr1[] = new int[] {1,2,3,4,5,6};
        System.out.println(binarySearch(8,arr1));
        int arr4[] = new int[] {1,3,8,9,15};
        int arr5[] = new int[] {7,11,19,21,22,25};
        System.out.println(medianOf2SortedArrays(arr4,arr5));
        int arr6[] = new int[] {1,60,-10,70,80,-85};
        TwoElementsWithSumClosestToZero(arr6);
        int arr7[] = new int[] {1,2,8,10,10,12,19};
        System.out.println("ceiling");
        ceilingAndFloorInSortedArray(20,arr7);
        int arr8[] = new int[] {0, 2, 5, 8, 17};
        System.out.println(fixedPoint(arr8));
        int arr11[] = new int[] {1, 5, 10, 20, 40, 80};
        int arr12[] = new int[] {6, 7, 20, 80, 100};
        int arr13[] = new int[] {3, 4, 15, 20, 30, 70, 80, 120};
        findCommon(arr11,arr12,arr13);
        int arr14[] = new int[] {1, 4, 5, 7};
        int arr15[] = new int[] {10, 20, 30, 40};
        findClosestFrom2SortedArrays(arr14,arr15,50);
        int arr16[] = new int[] {11, 15, 26, 38, 9, 10};
        pairWithGivenSumInSortedRotatedArray(arr16,45);
        int arr17[] = new int[] {1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8};
        System.out.println(elementThatAppearsOnlyOnce(arr17));
        int arr18[] = new int[] {1, -2, 1, 0, 5};
        findTripletWithSumZero(arr18);


        int bsarr[] = new int[] {1,2,3,4,5};
        System.out.println(binarySearchSorted(1,bsarr));
        System.out.println(binarySearchSorted(29,bsarr));
        System.out.println(binarySearchSorted(5,bsarr));
        System.out.println(binarySearchSorted(6,bsarr));
        System.out.println(binarySearchSorted(7,bsarr));

        int missing[] = new int[] {4, 3, 6, 2, 1, 1};
        findMissingAndRepeating(missing);
        System.out.println(maximumInFirstIncreasingThenDecreasing(new int[] {8, 10, 100, 80, 100, 200, 400, 500, 200, 1000, 1}));


        practiceDelete(new int[] {12 ,11, -13, -5, 6, -7, 5, -3, -6});
    }

    public static int maximumInFirstIncreasingThenDecreasing(int arr[]) {
        if(arr == null || arr.length == 0)
            return -1;
        if(arr.length == 1)
            return arr[0];
        int low = 0;
        int high = arr.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            System.out.println((mid)+" "+low+" "+high);
            if(mid>0 && mid<arr.length-1) {
                if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {
                    return arr[mid];
                }
                else if(arr[mid-1]>arr[mid]) {
                    high = mid-1;
                }
                else if(arr[mid+1]>arr[mid]) {
                    low = mid+1;
                }
            }
            else if(mid==0) {
                if(mid+1 < arr.length && arr[mid] > arr[mid+1]) {
                    return mid;
                }
            }
            else if(mid == arr.length-1) {
                if(mid-1>=0 && arr[mid] > arr[mid-1])
                    return arr.length-1;
            }
        }
        return -1;
    }

    /**
     * 5 6 7 1 2 -> mid=2 , low = 3 high = 4 -> mid = 3 -> high = 3;
     * @param x
     * @param bsarr
     * @return
     */
    public static int binarySearchSorted(int x,int bsarr[]) {
        int low = 0;
        int high = bsarr.length-1;
        int pivot = 0;
        /*
         * goal is have these boundries meet at the index of smallest element,
         * when mid element is greater than high , means we can narrow down our
         * search space by searching the right side , we do this because
         * middle element is for sure not the smallest and when middle element
         * is greater than the right one so it is reverse of the characteristics of
         * a sorted array. so we can narrow down our search to right side.
         */
        while(low<high) {
            int mid = (low+high)/2;
            if(bsarr[mid] > bsarr[high]) {
                low = mid+1;
            }
            else
                high = mid;
        }
        pivot = high;
        low = 0;
        high = bsarr.length-1;
        if(x>=bsarr[pivot] && x<=bsarr[high]) {
            low = pivot;
        }
        else {
            high = pivot-1;
        }
        System.out.println(pivot+" Pivot mil gya ! ");
        while(low<=high) {
            int mid = (low+high)/2;
            if(bsarr[mid] == x)
                return mid;
            else if(bsarr[mid] < x)
                low  = mid+1;
            else
                high = mid-1;
        }
        return -1;

    }

    // simple binarySearch.
    public static int binarySearch(int x,int arr[]) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]==x) {
                return mid;
            }
            else if(arr[mid]<x) {
                low = mid+1;
            }
            else
                high = mid-1;
        }
        return -1;
    }


    /**
     * This is a problem for finding a median of 2 sorted arrays of any size.
     * The idea is to divide the arrays into equal halves.
     * So let say we have 2 arrays arr1 of length 6 and arr2 of length 8.
     * Suppose we are partitioning these arrays like this arr1[] = x1 x2 | x3 x4 x5 x6 & arr2[] = y1 y2 y3 y4 y5 | y6 y7 y8. Now we have to
     * make sure that all the elements on the left side is smaller than the right side for that we will use 2 conditions
     * x2 <= y6 && y5 <= x3 . If this is the case then median would be avg(Max(x2,y5),Min(x3,y6)) and in case the total length is odd
     * then there will be one more element on left side so median would be Max(x2,y5).
     * Now the problem reduces to finding this partition point in both arrays for which we will be using BinarySearch(on Smaller array).
     * So we will apply binary search on the smaller array and use mid as partitionX and based on formula
     * (sizeX+sizeY+1)/2 - partitionX = partitionY we will calculate the partitionY index.
     * Based on the comparison of elements we will move our partitionX index to the left or right side.
     * Time complexity will be O(Min(size1,size2))
     * @param arr1
     * @param arr2
     * @return
     */
    public static double medianOf2SortedArrays(int arr1[],int arr2[]) {
        if(arr1.length > arr2.length)
            return medianOf2SortedArrays(arr2,arr1);
        int x = arr1.length;
        int y = arr2.length;
        int low = 0;
        int high = x;
        while(low <= high) {
            int partitionX = (low+high)/2;
            int partitionY = (x+y+1)/2 - partitionX;
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX-1];
            int minRightX = (partitionX == x ) ? Integer.MAX_VALUE : arr1[partitionX];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY-1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : arr2[partitionY];
            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((x+y)%2 == 0 ) {
                    return (double)(Math.max(maxLeftX, maxLeftY)+Math.min(minRightY, minRightX))/2;
                }
                else
                    return (double)Math.max(maxLeftY, maxLeftX);
            }
            else if(maxLeftX > minRightY) {
                high = partitionX - 1;
            }
            else
                low = partitionX + 1;
        }
        return -1;
    }

    public static void TwoElementsWithSumClosestToZero(int arr[]) {
        if(arr.length < 2)
            return;
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length-1;
        int min_low = 0;
        int min_high = arr.length-1;
        int min_sum = Integer.MAX_VALUE;
        while(low<high) {
            int sum = arr[low]+arr[high];
            if(Math.abs(sum) < Math.abs(min_sum)) {
                min_low = low;
                min_high = high;
                min_sum = sum;
            }
            if(sum > 0) {
                high--;
            }
            if(sum < 0) {
                low++;
            }
        }
        System.out.println(arr[min_low]+" "+arr[min_high]);
    }

    /**
     * maximum and minimum element in minimum number of comparisons:-
     * 1. divide the array into 2 parts
     * 2. find maximum and minimum of both the parts
     * 3. final_min = Math.min(minimum_left,minimum_right) and
     * 4. final_max = Math.max(maximum_left,maximum_right).
     * @param x
     * @param arr
     */

    /**
     * while traversing , use the absolute value of every element as
     * an index and make the value at the index negative to mark it
     * visited , if something is already marked negative then
     * this is the repeating element , to find the missing
     * traverse the array again and look for a positive value.
     * @param arr
     */
    public static void findMissingAndRepeating(int arr[]) {
        for(int i = 0; i< arr.length; i++) {
            int abs_val = Math.abs(arr[i]);
            if(arr[abs_val - 1] > 0) {
                arr[abs_val-1] = -arr[abs_val-1];
            }
            else {
                System.out.println(abs_val);
            }
        }
        for(int i = 0; i<arr.length;i++)
        {
            if(arr[i]>0)
                System.out.println((i+1));
        }
    }

    public static void ceilingAndFloorInSortedArray(int x, int arr[]) {

        // First ceiling fun.

        int low = 0;
        int high = arr.length-1;
        int ceiling = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]>=x) {
                ceiling = arr[mid];
                high = mid-1;
            }
            else
                low = mid+1;
        }

        low = 0;
        high = arr.length-1;
        int floor = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]<=x) {
                floor = arr[mid];
                low = mid+1;
            }
            else
                high = mid-1;
        }
        System.out.println(ceiling+" "+floor);
    }

    /**
     * A fixed point is a point where arr[index] = index; we can use binarySearch , for the mid
     * if arr[mid] == mid return the value , if mid > arr[mid] fixed point lies on the right side else left;
     * reason why this works is when we say if mid > arr[mid] it means arr[mid] is behind the index mid by some value
     * and so all the values on the left side will be behind the index by some value because the array has only
     * distinct elements.
     * @param arr
     * @return
     */
    public static int fixedPoint(int arr[]) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid] == mid)
                return mid;
            if(mid > arr[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }


    /**
     * Find common elements in 3 sorted arrays.
     */
    public static void findCommon(int arr1[] , int arr2[] ,int arr3[]) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < arr1.length && j < arr2.length && k < arr3.length) {
            if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                System.out.print(arr1[i]+" ");
            }
            if(arr1[i] < arr2[j])
                i++;
            else if(arr2[j] < arr3[k])
                j++;
            else
                k++;
        }
        System.out.println();
    }

    public static void findClosestFrom2SortedArrays(int arr1[],int arr2[],int x) {
        int low = 0;
        int high = arr2.length-1;
        int diff = Integer.MAX_VALUE;
        int res_l = 0;
        int res_h = 0;
        while(low < arr1.length && high >= 0) {
            if(Math.abs(arr1[low]+arr2[high]-x) < diff) {
                res_l = low;
                res_h = high;
                diff = Math.abs(arr1[low]+arr2[high]-x);
            }
            if(arr1[low]+arr2[high]>x)
                high--;
            else
                low++;
        }
        System.out.println(arr1[res_l]+" "+arr2[res_h]);
    }

    public static void pairWithGivenSumInSortedRotatedArray(int arr[],int x) {
        int n = arr.length;
        int i = 0;
        for(i = 0; i < arr.length-1 ; i++)
            if(arr[i]>arr[i+1])
                break;
        int low = (i+1)%n;
        int high = i;
        int count = 0;
        while(low!=high) {
            if(arr[low]+arr[high]==x) {
                count++;
                if(low == (high-1+n)%n)
                {
                    System.out.println("number of pairs with sun x: "+count);
                    break;
                }
                low = (low+1)%n;
                high = (high-1+n)%n;
            }
            if(arr[low]+arr[high]<x) {
                low = (low+1)%n;
            }
            else
                high = (high-1+n)%n;

        }
        System.out.println(count);
    }

    /**
     * Find element that appears only once .
     * @param arr
     * @return
     */
    public static int elementThatAppearsOnlyOnce(int arr[]) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(low == high) {
                return arr[low];
            }
            if(mid%2 == 0 ) {
                if(arr[mid] == arr[mid+1])
                    low = mid+2;
                else
                    high = mid;
            }
            else {
                if(arr[mid] == arr[mid-1])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }

    public static void findTripletWithSumZero(int arr[]) {
        Arrays.sort(arr);
        for(int i = 0; i<arr.length-1; i++) {
            int left = i+1;
            int right = arr.length-1;
            int x = arr[i];
            while(left<right)
            {
                if(x+arr[left]+arr[right] == 0) {
                    System.out.println(x+" "+arr[left]+" "+arr[right]);
                    left++;
                    right--;

                }
                else if(x+arr[left]+arr[right]<0)
                    left++;
                else right--;
            }
        }
    }

    public static void practiceDelete(int arr[]) {
        int i = 0;
        for(int j=0;j<arr.length;j++) {
            if(arr[j]<0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        for(int j=0;j<arr.length;j++)
            System.out.print(arr[j]+" ");
    }



}
