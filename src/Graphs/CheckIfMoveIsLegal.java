package Graphs;
// You are given a 0-indexed 8 x 8 grid board, where board[r][c] represents the cell (r, c) on a game board. On the board, free cells are represented by '.', white cells are represented by 'W',and black cells are represented by 'B'.
//Each move in this game consists of choosing a free cell and changing it to the color you are playing as (either white or black). However, a move is only legal if, after changing it,
// the cell becomes the endpoint of a good line (horizontal, vertical, or diagonal).
//A good line is a line of three or more cells (including the endpoints) where the endpoints of the line are one color,
// and the remaining cells in the middle are the opposite color (no cells in the line are free). You can find examples for good lines in the figure below:
// https://leetcode.com/problems/check-if-move-is-legal/
public class CheckIfMoveIsLegal {
    public boolean checkMove(char[][] board, int r, int c, char color) {
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        char opp = color == 'B' ? 'W' : 'B';

        for(int i = 0; i < directions.length; i++) {
            int x = r + directions[i][0];
            int y = c + directions[i][1];

            boolean seenOpp = false, end = false;

            while(x >= 0 && x < 8 && y >= 0 && y < 8) {

                if(board[x][y] == opp) {
                    seenOpp = true;
                } else if(board[x][y] == color) {
                    end = true;
                    break;
                } else if(board[x][y] == '.') {
                    break;
                }
                x += directions[i][0];
                y += directions[i][1];
            }

            if(seenOpp && end) {
                return true;
            }
        }
        return false;
    }
}
