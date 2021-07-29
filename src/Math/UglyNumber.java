package Math;

// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
//Given an integer n, return true if n is an ugly number.
// https://leetcode.com/problems/ugly-number/submissions/
public class UglyNumber {
    public boolean isUgly(int n) {
        if(n > 0) {
            for(int i = 2; i < 6; i++) {
                while(n % i == 0) {
                    n /= i;
                }
            }
        }
        return n == 1;
    }
}
