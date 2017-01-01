package org.xuan.ints;

/**
 * Created by xzhou2 on 12/28/16.
 */
public class TrailingZeros_172 {
    public int trailingZeroes(int n) {
        int result = 0;
        int base = 5;
        while(true) {
            result += n / base;
            if (base <= n /5) {
                base *= 5;
            } else {
                break;
            }
        }
        return result;
    }
}
