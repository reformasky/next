package org.xuan.ints;

import java.util.Arrays;

/**
 * Created by xzhou2 on 1/25/17.
 */
public class SuperPower_372 {
    private static final int MOD = 1337;
    private static final int[] cacheBase = new int[10];
    private static final int[] cacheResidue = new int[MOD];
    public int superPow(int a, int[] b) {
        a %= MOD;
        if (a <= 1) {
            return a;
        }
        buildCacheBase(a);
        Arrays.fill(cacheResidue, -1);
        int result = 1;
        for(int i = 0; i < b.length; i++) {
            result = mod(result, b[i]);
        }
        return result;
    }

    private int mod(int left, int curr) {
        int pre = power10(left);
        return (pre * cacheBase[curr]) % MOD;
    }

    private int power10(int left) {
        if (cacheResidue[left] >= 0) {
            return cacheResidue[left];
        }
        int result = power(left, 10);
        cacheResidue[left] = result;
        return result;
    }

    private int power(int base, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow == 1) {
            return base;
        }
        int half = power(base, pow / 2);
        int result = (half * half) % MOD;
        return pow % 2 == 0 ? result : (result * base) % MOD;
    }


    private void buildCacheBase(int base) {
        cacheBase[0] = 1;
        for(int i = 1; i < 10; i++) {
            cacheBase[i] = (cacheBase[i - 1] * base) % MOD;
        }
    }
}
