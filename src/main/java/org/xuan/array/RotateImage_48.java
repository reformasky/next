package org.xuan.array;

/**
 * Created by xzhou2 on 12/2/16.
 */
public class RotateImage_48 {
    public void rotate(int[][] a) {
        int len = a.length;
        for(int i = 0; i < len / 2; i++) {
            for(int j = i; j < len - i - 1; j++) {
                int tmp = a[i][j];
                a[i][j] = a[len - 1 - j][i];
                a[len - 1 - j][i] = a[len - 1 - i][len - 1 - j];
                a[len - 1- i][len - 1- j] = a[j][len - 1 - i];
                a[j][len - 1 - i] = tmp;
            }
        }
    }
}
