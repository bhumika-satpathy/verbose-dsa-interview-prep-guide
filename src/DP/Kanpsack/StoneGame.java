package DP.Kanpsack;

import java.util.Arrays;

// Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
//The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
//Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.
// This continues until there are no more piles left, at which point the person with the most stones wins.
//Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
// https://leetcode.com/problems/stone-game/

/*
    Noteworthy approach: Keep adding the stone values and subtract the values for Lee. In short, it boils down to add element from the array except those that are that of Lee.
    Approach 2: Since Alex has the independence to start the game. She can choose to take the stone from any place and hence she always wins. So we can also always return true as an answer xD.
 */
public class StoneGame {
    int[][] dp = new int[501][501];
    public int stone(int[] piles, int start, int end) {
        // base condition
        if(start > end) {
            return 0;
        }

        if(dp[start][end] != -1) {
            return dp[start][end];
        }
        return dp[start][end] = Math.max(piles[start] - stone(piles, start + 1, end), piles[end] - stone(piles, start, end - 1));
    }

    public boolean stoneGame(int[] piles) {
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        stone(piles, 0, piles.length - 1);
        return dp[0][piles.length - 1] > 0;
    }
}
