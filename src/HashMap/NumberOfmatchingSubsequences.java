package HashMap;

import java.util.*;

// Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
//
//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//
//For example, "ace" is a subsequence of "abcde".
// https://leetcode.com/problems/number-of-matching-subsequences/
// Approach: For every character in the word, keep traversing upto a point where the word comes down to length 1 meaning that its a subsequence
public class NumberOfmatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<String>> map = new HashMap<>();

        for(char i = 'a'; i <= 'z'; i++) {
            map.put(i, new ArrayList<>());
        }

        for(String word: words) {
            map.get(word.charAt(0)).add(word);
        }

        int ans = 0;
        for(char ch: s.toCharArray()) {
            List<String> listOfWords = map.get(ch);
            int size = listOfWords.size();

            for(int i = 0; i < size; i++) {
                String word = listOfWords.get(0);
                listOfWords.remove(0);
                // If the remaining letters in the word are just one
                if(word.length() == 1) {
                    ans++;
                } else {
                    map.get(word.charAt(1)).add(word.substring(1));
                }
            }
        }

        return ans;
    }
}
