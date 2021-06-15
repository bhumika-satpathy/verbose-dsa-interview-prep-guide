package Greedy;

import java.util.Arrays;

// Given a string s and an array of integers cost where cost[i] is the cost of deleting the ith character in s.
//
//Return the minimum cost of deletions such that there are no two identical letters next to each other.
//
//Notice that you will delete the chosen characters at the same time, in other words, after deleting a character, the costs of deleting other characters will not change.
public class MinimumDeletionCostToAvoidRepeatingLetters {
    public int minCost(String s, int[] cost) {
        int i = 0;
        int totalCost = 0;

        while(i < s.length()) {
            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                int startIndex = i, endIndex = i;
                while(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                }
                endIndex = i;
                Arrays.sort(cost, startIndex, endIndex + 1);
                for(int j = startIndex; j < endIndex; j++) {
                    totalCost += cost[j];
                }
                i = endIndex + 1;
            } else {
                i++;
            }
        }
        return totalCost;
    }
}
