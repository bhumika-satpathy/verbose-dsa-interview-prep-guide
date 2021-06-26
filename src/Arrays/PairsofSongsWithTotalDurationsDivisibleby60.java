package Arrays;

// You are given a list of songs where the ith song has a duration of time[i] seconds.
//
//Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
public class PairsofSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int ans = 0;

        for(int t: time) {
            if(t % 60 == 0) {
                ans += remainders[0];
            } else {
                ans += remainders[60 - t % 60];
            }
            remainders[t % 60]++;
        }

        return ans;
    }
}
