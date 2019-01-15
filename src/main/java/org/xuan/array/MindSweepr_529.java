package org.xuan.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by xzhou2 on 3/28/17.
 */
public class MindSweepr_529 {
    private static final int[][] diffs = {{-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0) {
            return board;
        }
        int row = board.length, col = board[0].length;
        char[][] res = new char[row][col];
        for(int i = 0; i < row; i++) {
            res[i] = Arrays.copyOf(board[i], col);
        }
        if (board[click[0]][click[1]] == 'M') {
            res[click[0]][click[1]] = 'X';
        } else if (board[click[0]][click[1]] == 'E') {
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(click);
            while(!queue.isEmpty()) {
                int[] curr = queue.poll();
                if (res[curr[0]][curr[1]] == 'E') {
                    int count = getCount(board, curr);
                    if (count == 0) {
                        for(int[] d : diffs) {
                            int r = curr[0] + d[0], c = curr[1] + d[1];
                            if (r >= 0 && r < row && c >= 0 && c < col) {
                                if (board[r][c] == 'E') {
                                    queue.offer(new int[]{r, c});
                                }
                            }
                        }
                        res[curr[0]][curr[1]] = 'B';
                    } else {
                        res[curr[0]][curr[1]] = (char)(count + '0');
                    }
                }
            }
        }
        return res;
    }

    private int getCount(char[][] board, int[] curr) {
        int res = 0;
        int row = board.length, col = board[0].length;

        for(int[] d : diffs) {
            int r = curr[0] + d[0], c = curr[1] + d[1];
            if (r >= 0 && r < row && c >= 0 && c < col) {
                if (board[r][c] == 'M') {
                    res++;
                }
            }
        }
        return res;
    }


}
