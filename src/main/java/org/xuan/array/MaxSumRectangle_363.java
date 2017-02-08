package org.xuan.array;

import java.util.TreeSet;

/**
 * Created by xzhou2 on 1/24/17.
 */
public class MaxSumRectangle_363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int nRow = matrix.length, nCol = matrix[0].length;
        if (nRow > nCol) {
            int[][] transpose = new int[nCol][nRow];
            for(int i = 0; i < nRow; i++) {
                for(int j = 0; j < nCol; j++) {
                    transpose[j][i] = matrix[i][j];
                }
            }
            return maxSumSubmatrix(transpose, k);
        }
        int result = Integer.MIN_VALUE;
        for(int i = 0; i <nRow; i++) {
            int[] arr = new int[nCol];
            for(int j = i; j >= 0; j--) {
                int sum = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for(int m = 0; m < nCol; m++) {
                    arr[m] += matrix[j][m];
                    sum += arr[m];
                    Integer diff;
                    diff = set.ceiling(sum - k);
                    if (diff != null) {
                        result = Math.max(sum - diff, result);
                        if (result == k) {
                            return k;
                        }
                    }
                    set.add(sum);
                }
            }
        }
        return result;
    }

    public int maxSumSubmatrix_naive(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int nRow = matrix.length, nCol = matrix[0].length;
        if (nRow > nCol) {
            int[][] transpose = new int[nCol][nRow];
            for(int i = 0; i < nRow; i++) {
                for(int j = 0; j < nCol; j++) {
                    transpose[j][i] = matrix[i][j];
                }
            }
            return maxSumSubmatrix_naive(transpose, k);
        }
        int[][] sum = new int[nRow + 1][nCol + 1];
        for(int i = 1; i <= nRow; i++) {
            for(int j = 1; j <= nCol; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i-1][j-1] - sum[i-1][j - 1];
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i = 1; i <= nRow; i++) {
            for(int j = 1; j <= nCol; j++) {
                for(int n = 0; n < i; n++) {
                    for(int m = 0; m < j; m++) {
                        int s = sum[i][j] - sum[n][j] - sum[i][m] + sum[n][m];
                        if (s == k) {
                            return k;
                        } else if (s < k) {
                            result = Math.max(result, s);
                        }
                    }
                }
            }
        }
        return result;
    }
}
