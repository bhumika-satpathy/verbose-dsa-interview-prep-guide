package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// You are given an m x n integer matrix heights representing the height of each unit cell in a continent.
// The Pacific ocean touches the continent's left and top edges, and the Atlantic ocean touches the continent's right and bottom edges.
//Water can only flow in four directions: up, down, left, and right. Water flows from a cell to an adjacent one with an equal or lower height.
//Return a list of grid coordinates where water can flow to both the Pacific and Atlantic oceans.
// https://leetcode.com/problems/pacific-atlantic-water-flow/
public class PacificAtlanticWaterFlow {
    int rows;
    int cols;
    int[] connectedRows = new int[] {-1, 0, 0, 1};
    int[] connectedCols = new int[] {0, -1, 1, 0};
    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length == 0) {
            return null;
        }

        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;
        // Respective queues of pacific and atlantic covering the (top, left) edges for pacific and (bottom, right) edges for atlantic respectiely
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();

        for(int i = 0; i < heights.length; i++) {
            pacificQ.offer(new int[] {i, 0});
            atlanticQ.offer(new int[] {i, cols - 1});
        }

        for(int i = 0; i < cols; i++) {
            pacificQ.offer(new int[] {0, i});
            atlanticQ.offer(new int[] {rows - 1, i});
        }

        // Find all the points in the graph that are greater than one of the nodes in each of the queue meaning that are reachable
        // to the atlantic or the pacific ocean
        // Here visited in a global space doesn't make sense because a point might have to be traversed more than once for various regions,
        // be it pacific or atlantic. hence we make local level visited array inside the bfs function itself
        // Function returns all those points which are reachable to pacific or atalantic respectively
        boolean[][] pacificReferences = bfs(pacificQ);
        boolean[][] atlanticReferences = bfs(atlanticQ);

        List<List<Integer>> ans = new ArrayList<>();

        // Check for all those points for which both the ocean coordinates are true
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(pacificReferences[i][j] && atlanticReferences[i][j]) {
//                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;
    }

    boolean[][] bfs(Queue<int[]> queue) {
        boolean[][] references = new boolean[rows][cols];

        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            references[point[0]][point[1]] = true;

            for(int k = 0; k < 4; k++) {
                int newRow = point[0] + connectedRows[k];
                int newCol = point[1] + connectedCols[k];

                // These are invalid conditions
                if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols){
                    continue;
                }

                // If the new row and column are of height lesser than that of the current point, then they are unreachable via any ocean
                // they have to be great than or equal to the current point in order to be able to reach the ocean.
                // These conditions are laid out in the question
                if(heights[newRow][newCol] < heights[point[0]][point[1]]) {
                    continue;
                }

                // If cell is already traversed, then no need to traverse again
                if(references[newRow][newCol]) {
                    continue;
                }

                // If it has reached upto this point, then it means that the new points are reachable
                queue.add(new int[] {newRow, newCol});
            }
        }

        return references;
    }
}
