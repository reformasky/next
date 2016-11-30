package org.xuan.array;

/**
 * Created by xzhou2 on 11/28/16.
 */
public class ValidSoduku_36 {
    private static final int len = 9, cellLen = 3;
    public boolean isValidSudoku(char[][] board) {
        return validRow(board) && validCol(board) && validBlock(board);
    }

    private boolean validRow(char[][] board) {
        for(int r = 0; r < len; r++) {
            boolean[] visited = new boolean[len];
            for(char c : board[r]) {
                if (c >= '1' && c <= '9') {
                    if (visited[c - '1']) {
                        return false;
                    }
                    visited[c - '1'] = true;
                }

            }
        }
        return true;
    }

    private boolean validCol(char[][] board) {
        for(int c = 0; c < len; c++) {
            boolean[] visited = new boolean[len];
            for(int r = 0; r < len; r++) {
                int index = board[r][c] - '1';
                if (index >= 0 && index < len) {
                    if (visited[index]) {
                        return false;
                    }
                    visited[index] = true;
                }

            }
        }
        return true;
    }

    private boolean validBlock(char[][] board) {
        for(int b = 0; b < len; b++) {
            boolean[] visited = new boolean[len];
            for(int i = 0; i < cellLen; i++) {
                for(int j = 0; j < cellLen; j++) {
                    int r = i + b / cellLen * cellLen, c = j + b % cellLen * cellLen;
                    int index = board[r][c] - '1';
                    if (index >= 0 && index < len) {
                        if(visited[index]) {
                            return false;
                        }
                        visited[index] = true;
                    }

                }
            }
        }
        return true;
    }
}
