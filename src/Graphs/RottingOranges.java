package Graphs;

// You are given an m x n grid where each cell can have one of three values:
//
//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
public class RottingOranges {
    public boolean rotOranges(int[][] grid, int rot, int m, int n){
        int[] connectedRows = new int[] {-1, 0, 0, 1};
        int[] connectedCols = new int[] {0, -1, 1, 0};

        boolean continued = false;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == rot){
                    for(int k = 0; k < 4; k++){
                        int r = i + connectedRows[k], c = j + connectedCols[k];
                        if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
                            grid[r][c] = rot + 1;
                            continued = true;
                        }
                    }
                }
            }
        }
        return continued;
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int rot = 2;

        while(rotOranges(grid, rot, m, n))
            rot++;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
                if(grid[i][j] == 1)
                    return -1;
        }

        return rot - 2;
    }
}
