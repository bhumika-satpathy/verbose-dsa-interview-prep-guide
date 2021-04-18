package Graphs;
import LinkedLists.LinkedList;
import java.util.Queue;

// You are given an m x n grid rooms initialized with these three possible values.
//
//-1 A wall or an obstacle.
//0 A gate.
//INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
//Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
public class WallsAndGates {
    int empty = Integer.MAX_VALUE;
    int gate = 0;
    int obs = -1;
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == gate)
                    q.add(new int[] {i, j});
            }
        }

        int[] connectedRows = new int[] {-1, 0, 0, 1};
        int[] connectedCols = new int[] {0, -1, 1, 0};

        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0], c = p[1];

            for(int k = 0; k < 4; k++){
                int i = r + connectedRows[k], j = c + connectedCols[k];
                if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] != empty)
                    continue;
                rooms[i][j] = rooms[r][c] + 1;
                q.add(new int[] {i, j});
            }
        }
    }
}