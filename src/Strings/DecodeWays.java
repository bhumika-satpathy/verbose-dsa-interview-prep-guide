package Strings;

// A message containing letters from A-Z can be encoded into numbers using the following mapping:
//
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
//To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
//
//"AAJF" with the grouping (1 1 10 6)
//"KJF" with the grouping (11 10 6)
//Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
//
//Given a string s containing only digits, return the number of ways to decode it.
//
//The answer is guaranteed to fit in a 32-bit integer.

import java.util.Arrays;

public class DecodeWays {

    int[] dp = new int[101];
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0;
        Arrays.fill(dp, -1);
        return noOfWays(s, s.length());
    }


    int noOfWays(String s, int n){
        if(n == 0 || n == 1)
            return 1;

        if(dp[n] != -1)
            return dp[n];

        if(s.charAt(n - 1) == '0' && s.charAt(n - 2) == '0')
            return 0;
        if(s.charAt(n - 1) == '0'){
            return dp[n] = (s.charAt(n - 2) <= '2') ? noOfWays(s, n - 2) : 0;
        }
        if(s.charAt(n - 2) == '0'){
            return dp[n] = noOfWays(s, n - 1);
        }
        if(s.charAt(n - 2) >= '3' || (s.charAt(n - 1) > '6' && s.charAt(n - 2) >= '2')){
            return dp[n] = noOfWays(s, n - 1);
        }
        if(noOfWays(s, n - 1) != 0 && noOfWays(s, n - 2) != 0)
            return dp[n] = noOfWays(s, n - 1) + noOfWays(s, n - 2);
        return dp[n] = 0;
    }

}
