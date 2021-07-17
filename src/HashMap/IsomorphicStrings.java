package HashMap;

import java.util.HashMap;

// Given two strings s and t, determine if they are isomorphic.
//
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
// https://leetcode.com/problems/isomorphic-strings/solution/
public class IsomorphicStrings {
    String transformStr(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        StringBuilder str = new StringBuilder("");

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch, i);
            }
            str.append(Integer.toString(map.get(ch)));
        }

        return str.toString();
    }

    public boolean isIsomorphic(String s, String t) {
        return transformStr(s).equals(transformStr(t));
    }
}
