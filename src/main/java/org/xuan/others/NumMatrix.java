package org.xuan.others;

/**
 * Created by xzhou2 on 1/11/17.
 */
public class NumMatrix {
    int[][] sums;
    public NumMatrix(int[][] matrix) {
         if (matrix.length == 0) return;
        sums = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < sums.length; i++) {
            for(int j = 0; j < sums[0].length; j++) {
                sums[i][j] = matrix[i][j];
                if (i > 0 && j > 0) {
                    sums[i][j] += sums[i][j - 1] + sums[i - 1][j] - sums[i - 1][j - 1];
                } else if (i > 0) {
                    sums[i][j] += sums[i-1][j];
                } else if (j > 0) {
                    sums[i][j] += sums[i][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return sums[row2][col2];
        } else if (row1 == 0) {
            return sums[row2][col2] - sums[row2][col1 - 1];
        } else if (col1 == 0) {
            return sums[row2][col2] - sums[row1 - 1][col2];
        } else {
            return sums[row2][col2] - sums[row1 - 1][col2] - sums[row2][col1 - 1] + sums[row1 - 1][col1 - 1];
        }
    }
}
