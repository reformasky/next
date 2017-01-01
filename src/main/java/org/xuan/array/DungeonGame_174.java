package org.xuan.array;

/**
 * Created by xzhou2 on 12/29/16.
 */
public class DungeonGame_174 {
    public int calculateMinimumHP(int[][] d) {
        if (d.length == 0 || d[0].length == 0) {
            return 1;
        }
        int nRow = d.length, nCol = d[0].length;
        int[] cache = new int[nCol];
        cache[nCol - 1] = Math.max(1, 1 - d[nRow - 1][nCol - 1]);
        for(int c = nCol - 2; c >= 0; c--) {
            cache[c] = Math.max(1, cache[c + 1] - d[nRow - 1][c]);
        }
        for(int r = nRow - 2; r >= 0; r--) {
            cache[nCol - 1] = Math.max(1, cache[nCol - 1] - d[r][nCol -1]);
            for(int c = nCol - 2; c >= 0; c--) {
                cache[c] = Math.max(1, Math.min(cache[c + 1], cache[c]) - d[r][c]);
            }
        }
        return cache[0];
    }
}
