package DP.Kanpsack;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//Note that the same word in the dictionary may be reused multiple times in the segmentation.
// https://leetcode.com/problems/word-break/
public class WordBreak {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length() + 1];

        Set<String> dict = new HashSet<>();
        for(String word: wordDict) {
            dict.add(word);
        }

        return canWordForm(s, 0, dict);
    }

    boolean canWordForm(String s, int start, Set<String> wordDict) {
        if(start == s.length()) {
            return true;
        }

        if(dp[start] != null) {
            return dp[start];
        }

        // Try checking if the dictionary holds words until the end and next word set of words can be formed such that they can be found inside the dictionary.
        for(int end = start + 1; end <= s.length() ; end++) {
            if(wordDict.contains(s.substring(start, end)) && canWordForm(s, end, wordDict)) {
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}
