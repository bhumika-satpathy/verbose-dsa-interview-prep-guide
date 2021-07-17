package Graphs;

import java.util.*;
// You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
//
//A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
//
//Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
//
// https://leetcode.com/problems/number-of-enclaves/
/*
    Approach: Consider the border(edges) grid with land and eventually cancel their trail out by flipping their diagonally connected blocks from 1 to 0 if any so that the graph is not considered.
*/
public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int res = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    q.add(new int[] {i, j});
                }
                res += grid[i][j];
            }
        }

        while(!q.isEmpty()) {
            int[] coords = q.poll();
            if(coords[0] < 0 || coords[0] >= m || coords[1] < 0 || coords[1] >= n || grid[coords[0]][coords[1]] != 1) {
                continue;
            }
            grid[coords[0]][coords[1]] = 0;
            // Execute his stp only when grid[i][j] == 1
            res--;
            q.add(new int[]{coords[0], coords[1] - 1});
            q.add(new int[]{coords[0] - 1, coords[1]});
            q.add(new int[]{coords[0], coords[1] + 1});
            q.add(new int[]{coords[0] + 1, coords[1]});
        }

        return res;
    }
}
