package org.xuan.array;

/**
 * Created by xzhou2 on 1/18/17.
 */
public class LongestIncreasingPath_329 {
    private static final int[][] diffs = new int[][] {
            new int[]{-1, 0}, new int[]{1,0}, new int[]{0, -1}, new int[]{0, 1}
    };
    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                result = Math.max(result, dfs(matrix, cache, r, c));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int[][] cache, int r, int c) {
        if (cache[r][c] > 0) {
            return cache[r][c];
        }
        int result = 1;
        for(int[] diff : diffs) {
            int newR = r + diff[0], newC = c + diff[1];
            if (newR >= 0 && newR < cache.length && newC >= 0 && newC < cache[0].length
                    && matrix[r][c] < matrix[newR][newC]) {
                result = Math.max(1 + dfs(matrix, cache, newR, newC), result);
            }
        }
        cache[r][c] = result;
        return result;
    }
}
