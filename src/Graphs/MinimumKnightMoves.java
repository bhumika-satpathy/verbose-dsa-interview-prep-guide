package Graphs;

import java.util.*;

// In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
//
//A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
// https://leetcode.com/problems/minimum-knight-moves/
public class MinimumKnightMoves {
    int[][] moves = new int[][] {{1, 2}, {-1, 2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {-1, -2}, {1, -2}};
    boolean[][] visited = new boolean[605][605];

    boolean isValid(int row, int col) {
        return !visited[row + 302][col + 302];
    }
    public int minKnightMoves(int x, int y) {
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int[] node = null;

        while(!q.isEmpty()) {
            int levelSize = q.size();
            for(int j = 0; j < levelSize; j++) {
                node = q.poll();
                if(node[0] == x && node[1] == y) {
                    return res;
                }

                for(int i = 0; i < moves.length; i++) {
                    int newX = node[0] + moves[i][0];
                    int newY = node[1] + moves[i][1];

                    if(isValid(newX, newY)) {
                        visited[newX + 302][newY + 302] = true;
                        q.add(new int[]{newX, newY});
                    }
                }
            }
            res++;
        }

        return res;
    }
}
