package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 12/6/16.
 */
public class UniquePathI_62 {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] cache = new int[n];
        Arrays.fill(cache, 1);
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                cache[j] += cache[j - 1];
            }
        }
        return cache[n - 1];
    }
}
