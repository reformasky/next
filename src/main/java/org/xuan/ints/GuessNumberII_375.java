package org.xuan.ints;

/**
 * Created by xzhou2 on 1/25/17.
 */
public class GuessNumberII_375 {
    public int getMoneyAmount(int n) {
        int[][] cache = new int[n][n];
        for(int i = 0; i < n; i++) {
            cache[i] = new int[n];
            if (i < n - 1) {
                cache[i][i+1] = i + 1;
            }
        }
        for(int diff = 2; diff < n; diff++) {
            for(int i = 0; i + diff < n; i++) {
                int j = i + diff;
                int min = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; k++) {
                    min = Math.min(k+1 + Math.max(cache[i][k - 1], cache[k + 1][j]), min);
                }
                cache[i][j] = min;
            }
        }
        return cache[0][n-1];
    }
}
