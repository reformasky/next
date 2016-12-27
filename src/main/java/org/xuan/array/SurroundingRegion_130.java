package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class SurroundingRegion_130 {

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int nRow = board.length, nCol = board[0].length;
        int last = nRow * nCol;
        UnionFound uf = new UnionFound(last + 1);
        for(int i = 0; i < nRow; i++) {
            if (board[i][0] == 'O') {
                uf.join(last, i * nCol);
            }
            if (board[i][nCol - 1] == 'O') {
                uf.join(last, i * nCol + nCol - 1);
            }
        }
        for(int i = 1; i < nCol - 1; i++) {
            if (board[0][i] == 'O') {
                uf.join(last, i);
            }
            if (board[nRow - 1][i] == 'O') {
                uf.join(last, (nRow - 1) * nCol + i);
            }
        }

        for(int i = 1; i < nRow; i++) {
            for(int j = 1; j < nCol; j++) {
                if (board[i][j] == 'O') {
                    if (board[i-1][j] == 'O') {
                        uf.join(i * nCol + j, (i - 1) * nCol + j);
                    }
                    if (board[i][j - 1] == 'O') {
                        uf.join(i * nCol + j, i * nCol + j - 1);
                    }
                }
            }
        }

        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                if(!uf.isJoind(i * nCol + j, last)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    class UnionFound {
        int[] root;
        int[] weight;
        public UnionFound(int n) {
            root = new int[n];
            weight = new int[n];
            for(int i = 0; i < n; i++) {
                root[i] = i;
            }
            Arrays.fill(weight, 1);
        }

        private int findRoot(int i) {
            while(root[i] != i) {
                i = root[i];
            }
            return i;
        }

        public void join(int i, int j) {
            int root_i = findRoot(i), root_j = findRoot(j);
            if (root_i != root_j) {
                if (weight[root_i] >= weight[root_j]) {
                    weight[root_i] += weight[root_j];
                    root[root_j] = root_i;
                } else {
                    weight[root_j] += weight[root_i];
                    root[root_i] = root_j;
                }
            }
        }

        public boolean isJoind(int i, int j) {
            return findRoot(i) == findRoot(j);
        }
    }










    private static final int[][] diffs = new int[][]{
            new int[]{1,0}, new int[]{-1,0}, new int[]{0,1}, new int[]{0, -1}
    };
    public void solve_dfs(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        for(int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);

            }
        }
        for(int i = 1; i < board[0].length - 1; i++) {
            if(board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i);
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '*') {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (board[i][j] != '*') {
            board[i][j] = '*';
            for(int[] diff : diffs) {
                int row = i + diff[0], col = j + diff[1];
                if (row >= 0 && row < board.length && col > 0 && col < board[0].length -1
                        &&  board[row][col] == 'O') {
                    dfs(board, row, col);
                }
            }
        }
    }
}
