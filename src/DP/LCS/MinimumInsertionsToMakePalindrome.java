package DP.LCS;

// Given a string str, the task is to find the minimum number of characters to be inserted to convert it to palindrome.
public class MinimumInsertionsToMakePalindrome {

    // Approach:
    // Find the longest palindromic subsequence of the string and subtract it from the length of the string

    int Solution(String str){
        LPS lps = new LPS();
        int len = lps.topDownDp(str);

        return str.length() - len;
    }

}
