package org.xuan.tree;

/**
 * Created by xzhou2 on 12/15/16.
 */
public class NumberOfUniqueBSTs_96 {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[][] cache = new int[n][n];
        for(int i = 0; i < n; i++) {
            cache[i][i] = 1;
        }
        for(int diff = 1; diff < n; diff++) {
            for(int left = 0; left < n - diff; left++) {
                int right = left + diff;
                int curr = 0;
                for(int r = left; r <= right; r++) {
                    int small = (r > left) ? cache[left][r - 1] : 1,
                            large = (r < right) ? cache[r + 1][right] : 1;
                    curr += small * large;
                }
                cache[left][right] = curr;
            }
        }
        return cache[0][n - 1];
    }
}
