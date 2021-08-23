package Arrays;

import java.util.*;

// Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.
// https://leetcode.com/problems/array-of-doubled-pairs/
public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] nums) {
        Integer[] arr = new Integer[nums.length];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, Comparator.comparingInt(Math::abs));
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: arr) {
            map.put(num, map.getOrDefault(num , 0) + 1);
        }

        for(int num: arr) {
            // This means that num/2 exists and num is partnered with num/2 and is already consumed
            if(map.get(num) == 0) {
                continue;
            }
            // If the map doesn't contain any partner from the array, then the desired array cannot be formed
            if(map.getOrDefault(num * 2, 0) <= 0) {
                return false;
            }

            map.put(num, map.get(num) -1);
            map.put(num * 2, map.get(num * 2) - 1);
        }

        return true;
    }
}
