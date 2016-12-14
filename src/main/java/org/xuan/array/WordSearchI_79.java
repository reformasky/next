package org.xuan.array;

/**
 * Created by xzhou2 on 12/12/16.
 */
public class WordSearchI_79 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, visited, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index, boolean[][] visited, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }
        if (board[i][j] != word.charAt(index)|| visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if (i > 0 && dfs(i - 1, j, index + 1, visited, board, word)) {
            return true;
        }
        if (i < board.length - 1 && dfs(i + 1, j, index + 1, visited, board, word)) {
            return true;
        }
        if (j > 0 && dfs(i, j - 1, index + 1, visited, board, word)) {
            return true;
        }
        if (j < board[0].length - 1 && dfs(i, j + 1, index + 1, visited, board, word)) {
            return true;
        }

        visited[i][j] = false;
        return word.length() == 1;
    }
}
