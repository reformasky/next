package org.xuan.array;

/**
 * Created by xzhou2 on 3/12/17.
 */
public class DiagnalTranverse_498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;

        int[] result = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];

            if (row >= m) { row = m - 1; col += 2; d = 1 - d;}
            if (col >= n) { col = n - 1; row += 2; d = 1 - d;}
            if (row < 0)  { row = 0; d = 1 - d;}
            if (col < 0)  { col = 0; d = 1 - d;}
        }

        return result;
    }


    public int[] findDiagonalOrder_br(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length, col = matrix[0].length;
        int index = 0, r = 0, c = 0;
        int[] result = new int[row * col];
        boolean right = true;
        while(index < result.length) {
            result[index++] = matrix[r][c];
            if (r == 0) {
                if (c + 1 <  col) {
                    c++;
                } else {
                    r++;
                }
                while(c - 1 >= 0 && r + 1 < row) {
                    result[index++] = matrix[r++][c--];
                }
            } else if (c == 0) {
                if (r + 1 < row) {
                    r++;
                } else {
                    c++;
                }
                while(c  + 1 < col && r  - 1 >= 0) {
                    result[index++] = matrix[r--][c++];
                }
            } else if (r == row - 1) {
                c++;
                while(c + 1 < col && r - 1 >= 0) {
                    result[index++] = matrix[r--][c++];
                }
            } else {
                r++;
                while(c - 1 >= 0 && r + 1 < row) {
                    result[index++] = matrix[r++][c--];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix  = {{1,2,3},{4,5,6}, {7,8,9},{10,11,12}, {13,14,15}};
        DiagnalTranverse_498 d = new DiagnalTranverse_498();
        d.findDiagonalOrder(matrix);
    }
}
