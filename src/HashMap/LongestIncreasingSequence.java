package HashMap;

import java.util.HashSet;

// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//You must write an algorithm that runs in O(n) time.
//
// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestIncreasingSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();

        for(int num: nums) {
            numSet.add(num);
        }

        int maxStreak = 0;

        for(int num: numSet) {
            // If num - 1 existed, then it would already have been covered
            if(!numSet.contains(num - 1)) {
                int currNum = num;
                int currLen = 1;

                while(numSet.contains(currNum + 1)) {
                    currNum++;
                    currLen++;
                }

                maxStreak = Math.max(currLen, maxStreak);
            }
        }

        return maxStreak;
    }
}
