package Strings;

// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
//
//The algorithm for myAtoi(string s) is as follows:
//
//    Read in and ignore any leading whitespace.
//    Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
//    Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
//    Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
//    If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
//    Return the integer as the final result.
//
//Note:
//
//    Only the space character ' ' is considered a whitespace character.
//    Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
// https://leetcode.com/problems/string-to-integer-atoi/
public class StringToInteger {
    public int myAtoi(String s) {
        int i = 0, base = 0, n = s.length();
        boolean isPositive = false;

        while(i < n && s.charAt(i) == ' ') {
            i++;
        }
        if(i < n && s.charAt(i) != '-') {
            isPositive = true;
        }
        if(!isPositive || s.charAt(i) == '+')i++;

        while(i < n && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
            if(base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = base * 10 + (s.charAt(i) - '0');
            i++;
        }
        return (isPositive ? base : -base);
    }
}

/*
    Conditions to be handled:
    discards all leading whitespaces
    sign of the number
    overflow
    invalid input
 */
