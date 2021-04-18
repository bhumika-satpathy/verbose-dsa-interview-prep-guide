package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList<>();

        int[] count = new int[26];
        HashMap<String, List<String>> ans = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            Arrays.fill(count, 0);

            StringBuilder str = new StringBuilder("");

            for(char ch: strs[i].toCharArray()){
                count[ch - 'a']++;
            }

            for(int j = 0; j < 26; j++){
                str.append("#");
                str.append(count[j]);
            }

            String key = str.toString();
            if(!ans.containsKey(key))
                ans.put(key, new ArrayList<>());
            ans.get(key).add(strs[i]);
        }
        return new ArrayList(ans.values());
    }
}
