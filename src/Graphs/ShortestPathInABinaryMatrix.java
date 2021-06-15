package Graphs;

import java.util.LinkedList;
import java.util.Queue;

// Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
//
//A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
//
//All the visited cells of the path are 0.
//All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
//The length of a clear path is the number of visited cells of this path.
//
// https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class ShortestPathInABinaryMatrix {
    int[] connectedRows = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] connectedCols = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0 || grid[0][0] == 1|| grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        int[] temp = null;
        int dist = 0;
        grid[0][0] = 1;

        while(!queue.isEmpty()) {
            temp = queue.poll();
            dist = grid[temp[0]][temp[1]];
            if(temp[0] == grid.length - 1 && temp[1] == grid[0].length - 1) {
                return dist;
            }
            for(int i = 0; i < 8; i++) {
                int newRow = connectedRows[i] + temp[0];
                int newCol = connectedCols[i] + temp[1];

                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 0) {
                    queue.add(new int[] {newRow, newCol});
                    grid[newRow][newCol] = dist + 1;
                }
            }
        }

        return -1;
    }
}
