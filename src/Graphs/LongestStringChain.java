package Graphs;

import java.util.*;

// You are given an array of words where each word consists of lowercase English letters.
//wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
//For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
//A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
//Return the length of the longest possible word chain with words chosen from the given list of words.
// https://leetcode.com/problems/longest-string-chain/
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        HashMap<String, Integer> memo = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        int ans = 0;

        Collections.addAll(set, words);
        for(int i = 0; i < words.length; i++) {
            ans = Math.max(ans, dfs(memo, set, words[i]));
        }
        return ans;
    }

    int dfs(HashMap<String, Integer> memo, HashSet<String> set, String word) {
        if(memo.containsKey(word)) {
            return memo.get(word);
        }

        int maxLength = 1;
        StringBuilder str = new StringBuilder(word);
        for(int i = 0; i < str.length(); i++) {
            str.deleteCharAt(i);
            String newWord = str.toString();

            if(set.contains(newWord)) {
                int ans = 1 + dfs(memo, set, newWord);
                maxLength = Math.max(maxLength, ans);
            }
            str.insert(i, word.charAt(i));
        }

        memo.put(word, maxLength);
        return maxLength;
    }
}
