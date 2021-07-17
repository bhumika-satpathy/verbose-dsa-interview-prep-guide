package Strings;

// order and str are strings composed of lowercase letters. In order, no letter occurs more than once.
//
//order was sorted in some custom order previously. We want to permute the characters of str so that they match the order that order was sorted. More specifically, if x occurs before y in order, then x should occur before y in the returned string.
//
//Return any permutation of str (as a string) that satisfies this property.
// https://leetcode.com/problems/custom-sort-string
public class CustomSortString {
    public String customSortString(String order, String str) {
        if(order.length() == 0) {
            return str;
        }
        int[] freq = new int[26];
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        for(char ch: order.toCharArray()) {
            for(int i = 0; i < freq[ch - 'a']; i++) {
                res.append(ch);
            }
            freq[ch - 'a'] = 0;
        }

        for(int i = 0; i < 26; i++) {
            while(freq[i] > 0) {
                res.append((char)(i + 'a'));
                freq[i]--;
            }
        }

        return res.toString();
    }
}
