package Graphs;

import java.util.LinkedList;
import java.util.Queue;

// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
//
//The distance between two adjacent cells is 1.
// https://leetcode.com/problems/01-matrix/

// Approach: Collect the 0s in the matrix into a queue and then find the nearest 1 and fix the distance accordingly
public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int[] connectedRows = new int[] {-1, 0, 0, 1};
        int[] connectedCols = new int[] {0, -1, 1, 0};
        Queue<int[]> queue = new LinkedList<>();

        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new int[] {i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int newRow = connectedRows[i] + node[0];
                int newCol = connectedCols[i] + node[1];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && mat[newRow][newCol] > mat[node[0]][node[1]] + 1) {
                    mat[newRow][newCol] = 1 + mat[node[0]][node[1]];
                    queue.add(new int[] {newRow, newCol});
                }
            }
        }

        return mat;
    }
}
