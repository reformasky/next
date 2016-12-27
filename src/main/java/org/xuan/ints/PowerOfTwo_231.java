package org.xuan.ints;

/**
 * Created by xzhou2 on 12/22/16.
 */
public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while((n & 1) == 0) {
            n >>= 1;
        }
        return n == 1;
    }
}
