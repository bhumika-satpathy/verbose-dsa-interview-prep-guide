package BinarySearch;

// Given an array with values ranging from 1 to the max length of the array. Find the missing and the repeating element in the array
public class FindMissingAndRepeatingElement {

    void findMissingAndRepeating(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int ele = arr[i];
            if(Math.abs(arr[ele]) > 0)
                arr[ele] = -arr[ele];
            else
                System.out.println("Repeating Element is " + ele);
        }

        for(int i = 0; i < arr.length; i++)
            if(arr[i] > 0)
                System.out.println("Missing element is " + i + 1);
    }

}
