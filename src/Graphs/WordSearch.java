package Graphs;

import java.util.Arrays;

// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
// https://leetcode.com/problems/word-search/
public class WordSearch {
    boolean[][] visited;
    int[][] DIRECTIONS = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    boolean isValid(int row, int col, char[][] board) {
        return row >= 0 && row < board.length &&
                col >= 0 && col < board[0].length && !visited[row][col];
    }

    void reFormVisitedArray() {
        for(int k = 0; k < visited.length; k++) {
            Arrays.fill(visited[k], false);
        }
    }

    boolean dfs(int row, int col, char[][] board, String word) {
        if(word.length() == 0) {
            return true;
        }
        visited[row][col] = true;
        boolean ans = false;

        for(int i = 0; i < DIRECTIONS.length; i++) {
            int newX = DIRECTIONS[i][0] + row;
            int newY = DIRECTIONS[i][1] + col;

            if(isValid(newX, newY, board) && board[newX][newY] == word.charAt(0)) {
                visited[row][col] = true;
                if(dfs(newX, newY, board, word.substring(1))) {
                    return true;
                }
            }
        }
        // This denotes unsuccessful traversal and hence get the node back by making it false
        // so that it will be helpful for other traversals
        visited[row][col] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // this step is necessary because the next time you would want to visit a node,
                // that was traversed earlier too, it should be traversible because every traversal is different in itself
                reFormVisitedArray();
                // check for each character in the board
                if(board[i][j] == word.charAt(0) && dfs(i, j, board, word.substring(1))) {
                    return true;
                }
            }
        }
        return false;
    }
}
