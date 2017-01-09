package org.xuan.ints;

/**
 * Created by xzhou2 on 1/8/17.
 */
public class UglyNumberI_263 {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        int[] factors = new int[]{2,3,5};
        for(int f : factors) {
            while(num % f == 0) {
                num /= f;
            }
        }
        return num == 1;
    }
}
