package org.xuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 1/2/17.
 */
public class WordSearchII_212 {
    private TrieNode root = new TrieNode();
    private static final int[][] diffs = new int[][]{
            new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[] {0, -1}
    };
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (words.length == 0 || board.length == 0 || board[0].length == 0) {
            return result;
        }
        for(String w: words) {
            addWord(w);
        }
        if (root.isLeave) {
            result.add("");
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                dfs(root, board, r, c, visited, sb,  result);
            }
        }
        return result;
    }

    private void dfs(TrieNode root, char[][] board, int r, int c, boolean[][] visited, StringBuilder path, List<String> result) {

        visited[r][c] = true;
        TrieNode node = root.trieNodes[board[r][c] - 'a'];
        if (node != null) {
            path.append(board[r][c]);
            if (node.isLeave) {
                node.isLeave = false;
                result.add(path.toString());
            }
            for(int[] diff : diffs) {
                int nr = r + diff[0], nc = c + diff[1];
                if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length
                        && !visited[nr][nc]) {
                    dfs(node, board, nr, nc, visited, path, result);
                }
            }
            path.deleteCharAt(path.length() - 1);
        }

        visited[r][c] = false;

    }


    class TrieNode {
        private static final int len = 26;
        // Initialize your data structure here.
        boolean isLeave;
        TrieNode[] trieNodes;
        public TrieNode() {
            isLeave = false;
            trieNodes = new TrieNode[26];
        }
    }

    // Adds a word into the data structure.
    private void addWord(String s) {
        TrieNode node = root;
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (node.trieNodes[index] == null) {
                node.trieNodes[index] = new TrieNode();
            }
            node = node.trieNodes[index];
        }
        node.isLeave = true;
    }
}
