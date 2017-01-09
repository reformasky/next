package org.xuan.ints;

/**
 * Created by xzhou2 on 1/8/17.
 */
public class UglyNumberII_264 {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int[] vals = new int[]{2,3,5},
                factors = new int[]{0,0,0},
                result = new int[n];
        result[0] = 1;
        int count = 1, res = Integer.MAX_VALUE;
        while(count < n) {
            res = Integer.MAX_VALUE;
            for(int i = 0; i < vals.length; i++) {
                res = Math.min(vals[i] * result[factors[i]], res);
            }
            for(int i = 0; i < vals.length; i++) {
                if (res == vals[i] * result[factors[i]]) {
                    factors[i]++;
                }
            }
            result[count++] = res;

        }
        return result[n - 1];
    }
}
