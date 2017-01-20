package org.xuan.array;

/**
 * Created by xzhou2 on 1/9/17.
 */
public class GameOfLive_289 {
    private static final int[][] diffs = new int[][] {
            new int[]{-1, -1}, new int[]{-1, 0}, new int[]{-1,1},
            new int[]{0, -1}, new int[]{0,1},
            new int[]{1, -1}, new int[]{1, 0}, new int[]{1,1}
    };
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int count = getCount(board, i, j);
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] % 3 == 0) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getCount(int[][] board, int i, int j) {
        int count = 0;
        for(int[] d : diffs) {
            int r = i + d[0], c = j + d[1];
            if (r >= 0 && r < board.length &&
                    c >= 0 && c < board[0].length
                    && board[r][c]% 2 == 1) {
                count++;
            }
        }
        return count;
    }
}
