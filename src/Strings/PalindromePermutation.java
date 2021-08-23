package Strings;

// Given a string s, return true if a permutation of the string could form a palindrome.
// https://leetcode.com/problems/palindrome-permutation/

// Note: Always remember that in a palindrome, the number of characters with odd number of occurrences should always be 1. If ever its greater than 1, then its definitely never a palindrome.
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int odd = 0;
        int[] chars = new int[26];

        for(char ch: s.toCharArray()) {
            chars[ch - 'a']++;
            if(chars[ch - 'a'] % 2 != 0) {
                odd++;
            } else {
                odd--;
            }
        }
        return odd <= 1;
    }
}
