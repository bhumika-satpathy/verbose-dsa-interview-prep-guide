package Sorting;

import java.util.Arrays;

public class Reorganize_String {
    public String reorganizeString(String S) {
        int[] chars = new int[26];

        for(char ch: S.toCharArray()){
            chars[ch - 'a'] += 100;
        }

        for(int i = 0; i < 26; i++)
            chars[i] += i;

        Arrays.sort(chars);

        char[] sol = new char[S.length()];
        int id = 1;
        for(int i = 0; i < chars.length; i++){
            int cnt = chars[i]/100;
            char ch = (char)('a' + chars[i]%100);

            if(cnt > (S.length() + 1)/2)
                return "";
            for(int j = 0; j < cnt; j++){
                if(id >= S.length())id = 0;
                sol[id] = ch;
                id += 2;
            }
        }

        return String.valueOf(sol);
    }
}
