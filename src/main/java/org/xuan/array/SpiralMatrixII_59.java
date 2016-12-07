package org.xuan.array;

/**
 * Created by xzhou2 on 12/5/16.
 */
public class SpiralMatrixII_59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++) {
            result[i] = new int[n];
        }
        int val = 1;
        for(int depth = 0; depth <= n/2; depth++) {
            for(int c = depth; c < n - depth - 1; c++) {
                result[depth][c] = val++;
            }
            for(int r = depth; r < n - depth - 1; r++) {
                result[r][n - depth - 1] = val++;
            }
            for(int c = n - depth - 1; c > depth; c--) {
                result[n - depth - 1][c] = val++;
            }
            for(int r = n - depth - 1; r > depth; r--) {
                result[r][depth] = val++;
            }
        }
        if (n % 2 == 1) {
            result[n/2][n/2] = val++;
        }
        return result;
    }
}
