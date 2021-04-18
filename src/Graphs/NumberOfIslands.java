package Graphs;

import java.util.LinkedList;
import java.util.Queue;

// Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island.
public class NumberOfIslands {

    boolean isValid(int row, int col, int[][] mat, Boolean[][] visited){
        return
                (row >= 0 && row < mat.length) &&
                        (col >= 0 && col < mat[0].length) &&
                            (mat[row][col] == 1 && !visited[row][col]);
    }

    void dfs(int[][] mat, int row, int col, Boolean[][] visited){

        visited[row][col] = true;

        int[] connectedRows = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] connectedCols = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};

        for(int k = 0; k < 8; k++){
            if(isValid(row + connectedRows[k], col + connectedCols[k], mat, visited))
                dfs(mat, row + connectedRows[k], col + connectedCols[k], visited);
        }
    }

    int numberOfIslands(int[][] mat){
        int row = mat.length, col = mat[0].length;
        Boolean[][] visited = new Boolean[row][col];
        int cnt = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!visited[i][j] && mat[i][j] == 1){
                    dfs(mat, i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

//    ----------------- BFS -----------------------------
    static class pair {
        int first, second;

        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    void bfs(int[][] mat, int row, int col, Boolean[][] visited){
        visited[row][col] = true;

        int[] connectedRows = new int[] {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] connectedCols = new int[] {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(row, col));

        while(!q.isEmpty()){
            pair p = q.poll();
            int i = p.first, j = p.second;

            for(int k = 0; k < 8; k++){
                if(isValid(i + connectedRows[k], j + connectedCols[k], mat, visited)){
                    visited[i + connectedRows[k]][j + connectedCols[k]] = true;
                    q.add(new pair(i + connectedRows[k], j + connectedCols[k]));
                }
            }
        }
    }

}
