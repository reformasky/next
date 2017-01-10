package org.xuan.ints;

/**
 * Created by xzhou2 on 1/8/17.
 */
public class PerfactSquare_279 {
    public int numSquares(int n) {
        int[] cache = new int[n + 1];
        cache[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            int curr = 5;
            for(long j = 1; true; j++) {
                long sq = j * j;
                if (sq > i) {
                    break;
                } else if (sq == i) {
                    curr = 1;
                    break;
                }
                curr = Math.min(cache[(int)sq] + cache[i - (int)sq], curr);
            }
            cache[i] = curr;

        }
        return cache[n];
    }
}
