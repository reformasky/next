package org.xuan.array;

/**
 * Created by xzhou2 on 12/7/16.
 */
public class MinPathSum_64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int nRow = grid.length, nCol = grid[0].length;
        int[] cache = new int[nCol];
        cache[0] = grid[0][0];
        for(int i = 1; i < nCol; i++) {
            cache[i] = grid[0][i] + cache[i - 1];
        }
        for(int r = 1; r < nRow; r++) {
            cache[0] += grid[r][0];
            for(int c = 1; c < nCol; c++) {
                cache[c] = Math.min(cache[c], cache[c - 1]) + grid[r][c];
            }
        }
        return cache[nCol - 1];
    }
}
