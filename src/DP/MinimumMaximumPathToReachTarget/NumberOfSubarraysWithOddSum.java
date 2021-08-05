package DP.MinimumMaximumPathToReachTarget;

// Given an array of integers arr. Return the number of sub-arrays with odd sum.
//As the answer may grow large, the answer must be computed modulo 10^9 + 7.
// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
// Refer to this for better understanding:
// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/discuss/754702/Some-hints-to-help-you-solve-this-problem-on-your-own
public class NumberOfSubarraysWithOddSum {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int even = 0, odd = 0;
        int n = arr.length;

        if(arr[n - 1] % 2 == 1) {
            odd++;
        } else {
            even++;
        }

        int res = odd;
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] % 2 == 1) {
                int tmp = odd;
                odd = 1 + even;
                even = tmp;
            } else {
                even++;
            }
            res += odd;
            res = res % mod;
        }

        return res % mod;
    }
}
