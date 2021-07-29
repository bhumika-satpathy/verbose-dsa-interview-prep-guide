package Arrays;

// Given a string s and an integer k. You should construct k non-empty palindrome strings using all the characters in s.
//
//Return True if you can use all the characters in s to construct k palindrome strings or False otherwise.
// https://leetcode.com/problems/construct-k-palindrome-strings/
public class ConstructKPalindromicStrings {
    public boolean canConstruct(String s, int k) {
        int odd = 0, n = s.length();
        int[] count = new int[26];

        for(char ch: s.toCharArray()) {
            count[ch - 'a'] ^= 1;
            odd += count[ch - 'a'] > 0 ? 1 : -1;
        }

        return k <= n && odd <= k;
    }
}

// Intuition
//
//Condition 1. odd characters <= k
//Count the occurrences of all characters.
//If one character has odd times occurrences,
//there must be at least one palindrome,
//with odd length and this character in the middle.
//So we count the characters that appear odd times,
//the number of odd character should not be bigger than k.
//
//Condition 2. k <= s.length()
//Also, if we have one character in each palindrome,
//we will have at most s.length() palindromes,
//so we need k <= s.length().
//
//The above two condition are necessary and sufficient conditions for this problem.
//So we return odd <= k <= n
