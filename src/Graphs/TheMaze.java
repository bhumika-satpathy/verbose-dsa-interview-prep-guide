package Graphs;

import java.util.LinkedList;
import java.util.Queue;

// There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
//
//Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.
//
// https://leetcode.com/problems/the-maze/
// Approach: Try to reach till the end of the wall.
public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int[] connectedRows = new int[] {-1, 0, 0, 1};
        int[] connectedCols = new int[] {0, -1, 1, 0};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();

            if(tmp[0] == destination[0] && tmp[1] == destination[1]) {
                return true;
            }

            for(int k = 0; k < 4; k++) {
                int newRow = connectedRows[k] + tmp[0];
                int newCol = connectedCols[k] + tmp[1];

                if(newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length && maze[newRow][newCol] == 0) {
                    // ball won't stop rolling until hitting a wall as specified in the question
                    while(newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length && maze[newRow][newCol] == 0) {
                        newRow += connectedRows[k];
                        newCol += connectedCols[k];
                    }
                    if(!visited[newRow - connectedRows[k]][newCol - connectedCols[k]]) {
                        queue.add(new int[] {newRow - connectedRows[k], newCol - connectedCols[k]});
                        visited[newRow - connectedRows[k]][newCol - connectedCols[k]] = true;
                    }
                }
            }
        }

        return false;
    }
}
