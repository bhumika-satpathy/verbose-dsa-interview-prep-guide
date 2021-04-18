package Strings;

import java.util.Arrays;

// Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
//
//If possible, output any possible result.  If not possible, return the empty string.
public class ReorganizeString {

    String Solution(String s){
        int[] count = new int[26];

        for(char ch: s.toCharArray())
            count[ch - 'a'] += 100;

        for(int i = 0; i < 26; i++)
            count[i] += i;

        Arrays.sort(count);
        char[] sol = new char[s.length()];
        int id = 1;
        for(int i = 0; i < count.length; i++){
            int cnt = count[i]/100;
            char ch = (char)('a' + count[i] % 100);

            if(cnt >= (s.length() + 1)/2)
                return "";

            for(int j = 0; j < cnt; j++){
                if(id >= s.length())
                    id = 0;
                sol[id++] = ch;
            }
        }

        return String.valueOf(sol);
    }

}
