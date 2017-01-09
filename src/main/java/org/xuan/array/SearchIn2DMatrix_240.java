package org.xuan.array;

/**
 * Created by xzhou2 on 1/6/17.
 */
public class SearchIn2DMatrix_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int nRow = matrix.length, nCol = matrix[0].length,
                r = nRow - 1, c = 0;
        while(r >= 0 && c < nCol) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                r--;
            } else {
                c++;
            }
        }
        return false;
    }
}
