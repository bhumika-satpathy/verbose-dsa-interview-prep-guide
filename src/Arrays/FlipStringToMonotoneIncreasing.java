package Arrays;

// A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).
//You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
//Return the minimum number of flips to make s monotone increasing.
// https://leetcode.com/problems/flip-string-to-monotone-increasing/
public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] p = new int[n + 1];
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            p[i + 1] = p[i] + (s.charAt(i) == '1' ? 1 : 0);
        }

        for(int i = 0; i <= n; i++) {
            ans = Math.min(ans, p[i] + (n - i) - (p[n] - p[i]));
        }

        return ans;
    }
}

// Approach:
/*
    Number of flips = number of ones in the first half(flip them all to zeros) + number of zeros in the second half(flip them all to 1)
    Reference video: https://youtu.be/7okODxrtO7A
 */