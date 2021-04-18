package Greedy;

import java.util.ArrayList;
import java.util.List;

// A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part,
// and return a list of integers representing the size of these parts.
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int i = 0, j = 0, anchor = 0;
        int[] index = new int[26];
        List<Integer> ans = new ArrayList<>();

        for(i = 0; i < S.length(); i++){
            index[S.charAt(i) - 'a'] = i;
        }

        for(i = 0; i < S.length(); i++){
            j = Math.max(j, index[S.charAt(i) - 'a']);
            if(i == j){
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
