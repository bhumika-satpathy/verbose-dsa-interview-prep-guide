package Strings;

// Given an array of characters chars, compress it using the following algorithm:
//
//Begin with an empty string s. For each group of consecutive repeating characters in chars:
//
//If the group's length is 1, append the character to s.
//Otherwise, append the character followed by the group's length.
//The compressed string s should not be returned separately, but instead be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
//
//After you are done modifying the input array, return the new length of the array.
//
//
//Follow up:
//Could you solve it using only O(1) extra space?
public class StringCompression {

    public int compress(char[] chars) {
        int j, len = 0, i = 0, w = 0;

        while(i < chars.length){
            j = i;
            while(i + 1 < chars.length && chars[i] == chars[i + 1])
                i++;
            len = i - j + 1;
            chars[w++] = chars[j];
            if(len > 1){
                for(char ch: String.valueOf(len).toCharArray())
                    chars[w++] = ch;
            }
            i++;
        }
        return w;
    }

}
