package Strings;

import java.util.*;

// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
// https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        List<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch, i);
                list.add(ch);
            } else {
                list.remove((Character)(ch));
            }
        }

        return list.size() == 0 ? -1 : map.get(list.get(0));
    }
}

// One pass solution using linked hash map
// public int firstUniqChar(String s) {
//        Map<Character, Integer> map = new LinkedHashMap<>();
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (set.contains(s.charAt(i))) {
//                if (map.get(s.charAt(i)) != null) {
//                    map.remove(s.charAt(i));
//                }
//            } else {
//                map.put(s.charAt(i), i);
//                set.add(s.charAt(i));
//            }
//        }
//        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
//    }
