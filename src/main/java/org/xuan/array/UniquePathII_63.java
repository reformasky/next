package org.xuan.array;

/**
 * Created by xzhou2 on 12/6/16.
 */
public class UniquePathII_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int nRow = obstacleGrid.length, nCol = obstacleGrid[0].length;
        int[] cache = new int[nCol];
        cache[0] = 1;
        for(int i = 1; i < nCol; i++) {
            cache[i] = obstacleGrid[0][i] == 1 ? 0 : cache[i - 1];
        }
        for(int i = 1; i < nRow; i++) {
            cache[0] = obstacleGrid[i][0] == 1 ? 0 : cache[0];
            for(int j = 1; j < nCol; j++) {
                cache[j] = obstacleGrid[i][j] == 1 ? 0
                        : (cache[j] + cache[j - 1]);
            }
        }
        return cache[nCol - 1];
    }
}
