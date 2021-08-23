package Arrays;

import java.util.HashMap;

// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
//
//Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
// https://leetcode.com/problems/longest-palindrome/
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        boolean odd = false;
        int ans = 0;
        int maxOdd = 0;

        for(int num: map.values()) {
            ans += num / 2 * 2;
        }

        return ans < s.length() ? ++ans : ans;
    }
}
//  We don't need to construct the palindrome, or thus identify the specific center character,
//  so we can just add 1 for a center character if needed at the very end. There is an extra character available anytime your answer is less than the length of the original string.
// Time: O(N), N = length of s
// Space: O(N). This can be reduced to O(1) by taking an array of fixed length, i.e, arr[128]
