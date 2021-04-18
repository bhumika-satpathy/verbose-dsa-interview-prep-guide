package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pArr = new int[26];
        int[] sArr = new int[26];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < p.length(); i++)
            pArr[p.charAt(i) - 'a']++;

        for(int i = 0; i < s.length(); i++){
            sArr[s.charAt(i) - 'a']++;

            if(i >= p.length()){
                sArr[(s.charAt(i - p.length()) - 'a')]--;
            }

            if(Arrays.equals(pArr, sArr))
                ans.add(i - p.length() + 1);
        }
        return ans;
    }
}
