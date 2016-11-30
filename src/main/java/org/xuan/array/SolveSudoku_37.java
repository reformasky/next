package org.xuan.array;

/**
 * Created by xzhou2 on 11/29/16.
 */
public class SolveSudoku_37 {
    private static final int len = 9;
    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int index) {
        if (index == len * len) {
            return true;
        }
        int r = index / len, c = index % len;
        if (board[r][c] == '.') {
            for(int i = 1; i < 10; i++) {
                board[r][c] = (char)(i + '0');
                if (isValid(board, r, c) && dfs(board, index + 1)) {
                    return true;
                }
            }
            board[r][c] = '.';
            return false;

        } else {
            return dfs(board, index + 1);
        }
    }

    private boolean isValid(char[][] board, int r, int c) {
        for(int i = 0; i < len; i++) {
            if (i != r && board[i][c] == board[r][c]) {
                return false;
            }
        }
        for(int i = 0; i < len; i++) {
            if (i != c && board[r][i] == board[r][c]) {
                return false;
            }
        }
        for(int i = 0; i < len / 3; i++) {
            for(int j = 0; j < len / 3; j++) {
                int tmp_r = r / 3 * 3 + i, tmp_c = c / 3 * 3 + j;
                if (!(tmp_r == r && tmp_c == c) && board[tmp_r][tmp_c] == board[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }
}
