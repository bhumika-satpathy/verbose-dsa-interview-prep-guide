package Sorting;

import java.util.HashMap;

public class Least_Number_of_Unique_Integers_after_K_Removals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num: arr){
            freq.put(num, 1 + freq.getOrDefault(num, 0));
        }

        int[] noOfOccurances = new int[arr.length + 1];
        for(int cnt: freq.values()){
            noOfOccurances[cnt]++;
        }

        int occurances = 1;
        int remains = freq.size();
        while(k > 0){
            if(k - (occurances * noOfOccurances[occurances]) >= 0){
                k -= (occurances * noOfOccurances[occurances]);
                remains -= noOfOccurances[occurances];
                occurances++;
            } else {
                return remains - k/occurances;
            }
        }

        return remains;
    }
}
