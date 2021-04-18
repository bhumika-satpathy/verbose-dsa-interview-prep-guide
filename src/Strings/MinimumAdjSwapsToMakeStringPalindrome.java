package Strings;

// Given a string s, the task is to find out the minimum no of adjacent swaps required to make string s palindrome. If it is not possible, then return -1.
/*
    Find the first matching character from the right half of the string and note that it is not supposed to be equal to the left ptr. Once a match is found, swap it to the desired location.
    Check youtube video for clarification: https://www.youtube.com/watch?v=zXpYs8j5oI8
 */
public class MinimumAdjSwapsToMakeStringPalindrome {
    int Solution(String str){
        int count = 0;

        char[] s = str.toCharArray();
        int n = s.length;
        for(int i = 0; i < n/2; i++){
            int left = i, right = n - i - 1;

            while(left < right){
                if(s[left] == s[right])
                    break;
                right--;
            }

            if(left == right)
                return -1;

            for(int j = right; j < n - i - 1; j++){
                char t = s[j];
                s[j] = s[j + 1];
                s[j + 1] = t;
                count++;
            }
        }

        return count;
    }
}
