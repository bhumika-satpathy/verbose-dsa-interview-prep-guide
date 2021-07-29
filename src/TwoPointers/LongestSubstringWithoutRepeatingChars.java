package TwoPointers;
import java.util.HashMap;

// Given a string s, find the length of the longest substring without repeating characters.
// Approach:
// Map all the indices of the corresponding chars in the map. If the char is already present, then calculate the length of the string from the next to current position
// j is supposed to be the maximum possible index of the last repeating char
public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;

        int i = 0, j = 0;
        for(i = 0, j = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                // handles cases like these: "abba"
                j = Math.max(map.get(ch), j);
            }

            ans = Math.max(ans, i - j + 1);
            map.put(ch, i + 1);
        }
        return ans;
    }
}
