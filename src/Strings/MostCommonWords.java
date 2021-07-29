package Strings;

import java.util.*;

// Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
//
//The words in paragraph are case-insensitive and the answer should be returned in lowercase.
// https://leetcode.com/problems/most-common-word/
public class MostCommonWords {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedStrings = new HashSet<>();

        for(String str: banned) {
            bannedStrings.add(str);
        }

        HashMap<String, Integer> map = new HashMap<>();
        int len = 0;
        String res = "";
        char[] chars = paragraph.toCharArray();
        StringBuilder buffer = new StringBuilder("");

        for(int i = 0; i < chars.length; i++) {
            char curr = chars[i];

            if(Character.isLetter(curr)) {
                buffer.append(Character.toLowerCase(curr));
                if(i != chars.length - 1) {
                    continue;
                }
            }

            if(buffer.length() > 0) {
                String word = buffer.toString();

                if(!bannedStrings.contains(word)) {
                    int newLen = map.getOrDefault(word, 0) + 1;
                    map.put(word, newLen);

                    if(newLen > len) {
                        len = newLen;
                        res = word;
                    }
                }
                buffer = new StringBuilder();
            }
        }
        return res;
    }
}
