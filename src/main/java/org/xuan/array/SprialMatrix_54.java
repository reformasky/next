package org.xuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 12/4/16.
 */
public class SprialMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int nRow = matrix.length, nCol = matrix[0].length,
                min = Math.min(nRow, nCol);

        for(int index = 0; index < min / 2; index++) {
            for(int c = index; c < nCol - index; c++) {
                result.add(matrix[index][c]);
            }
            for(int r = index + 1; r < nRow - index; r++) {
                result.add(matrix[r][nCol - index - 1]);
            }
            for(int c = nCol - index - 2; c >= index; c--) {
                result.add(matrix[nRow - index - 1][c]);
            }
            for(int r = nRow - index - 2; r > index; r--) {
                result.add(matrix[r][index]);
            }
        }
        if (min % 2 != 0) {
            if (nRow == min) {
                for(int c = min / 2; c < nCol - min / 2; c++) {
                    result.add(matrix[min / 2][c]);
                }
            } else {
                for(int r = min / 2; r < nRow - min / 2; r++) {
                    result.add(matrix[r][min / 2]);
                }
            }
        }
        return result;
    }
}
