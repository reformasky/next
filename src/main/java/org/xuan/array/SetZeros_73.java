package org.xuan.array;

/**
 * Created by xzhou2 on 12/9/16.
 */
public class SetZeros_73 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean firstRow = false, firstCol = false;
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                firstRow = true;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstCol) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
