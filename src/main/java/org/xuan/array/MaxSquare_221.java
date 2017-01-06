package org.xuan.array;

/**
 * Created by xzhou2 on 1/4/17.
 */
public class MaxSquare_221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int nRow = matrix.length, nCol = matrix[0].length, res = 0;
        int[][] lenSq = new int[nRow][nCol];
        for(int i = 0; i < nCol; i++) {
            lenSq[0][i] = matrix[0][i] == '1' ? 1 : 0;
            res = Math.max(lenSq[0][i], res);

        }
        for(int i = 1; i < nRow; i++) {
            lenSq[i][0] = matrix[i][0] == '1' ? 1 : 0;
            res = Math.max(lenSq[i][0], res);
            for(int j = 1; j < nCol; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                lenSq[i][j]  = min(lenSq[i][j-1], lenSq[i-1][j], lenSq[i-1][j-1]) + 1;
                res = Math.max(lenSq[i][j], res);
            }
        }
        return res * res;
    }

    private int min(int a, int b, int c) {
        return a > b ? b > c ? c : b
                : a > c ? c : a;
    }
}
