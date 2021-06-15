package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
//
//Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return the shortest distance for the ball to stop at the destination. If the ball cannot stop at destination, return -1.
//
//The distance is the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included).
// https://leetcode.com/problems/the-maze-ii/
// Note: Do only after solving maze 1(The Maze)
public class TheMazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int[] connectedRows = new int[] {-1, 0, 0, 1};
        int[] connectedCols = new int[] {0, -1, 1, 0};
        int[][] distances = new int[maze.length][maze[0].length];

        for(int i = 0; i < maze.length; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        distances[start[0]][start[1]] = 0;
        int cnt = 0;
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();

            for(int k = 0; k < 4; k++) {
                int newRow = connectedRows[k] + tmp[0];
                int newCol = connectedCols[k] + tmp[1];
                cnt = 0;
                while(newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length && maze[newRow][newCol] == 0) {
                    newRow += connectedRows[k];
                    newCol += connectedCols[k];
                    cnt++;
                }

                if(distances[newRow - connectedRows[k]][newCol - connectedCols[k]] > distances[tmp[0]][tmp[1]] + cnt) {
                    distances[newRow - connectedRows[k]][newCol - connectedCols[k]] = distances[tmp[0]][tmp[1]] + cnt;
                    queue.add(new int[] {newRow - connectedRows[k], newCol - connectedCols[k]});
                }
            }
        }

        return distances[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distances[destination[0]][destination[1]];
    }
}
