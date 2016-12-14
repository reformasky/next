package org.xuan.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xzhou2 on 12/9/16.
 */
public class SearchInMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int nRow = matrix.length, nCol = matrix[0].length;
        int low = 0, high = nRow - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][nCol - 1] == target) {
                return true;
            } else if (matrix[mid][nCol - 1] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low < nRow &&  Arrays.binarySearch(matrix[low], target) >= 0;
    }
}
