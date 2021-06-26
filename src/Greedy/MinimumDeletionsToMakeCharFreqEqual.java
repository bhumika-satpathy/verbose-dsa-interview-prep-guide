package Greedy;

import java.util.HashSet;

// A string s is called good if there are no two different characters in s that have the same frequency.
//Given a string s, return the minimum number of characters you need to delete to make s good.
//The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
public class MinimumDeletionsToMakeCharFreqEqual {
    public int minDeletions(String s) {
        HashSet<Integer> map = new HashSet<>();
        int ans = 0;
        int[] count = new int[26];
        for(char ch: s.toCharArray()){
            count[ch - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            int freq = count[i];
            // Note set.add returns a boolean. Returns: true if the newly added element doesn't exist, else false
            while(freq > 0 && !map.add(freq)){
                freq--;
                ans++;
            }
        }
        return ans;
    }
}
