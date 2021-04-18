package TwoPointers;

import java.util.Collections;
import java.util.HashMap;

public class LongestSubstringWithAtmostKChars {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0, i = 0, j = 0;

        while(j < s.length()){
            map.put(s.charAt(j), j++);
            if(map.size() > k){
                int lowestId = Collections.min(map.values());
                map.remove(s.charAt(lowestId));
                i = lowestId + 1;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
