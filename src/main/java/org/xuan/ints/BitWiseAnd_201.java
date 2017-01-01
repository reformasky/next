package org.xuan.ints;

/**
 * Created by xzhou2 on 12/29/16.
 */
public class BitWiseAnd_201 {
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0, mask = 1 << 31;
        for(int i = 31; i >= 0; i--) {
            if ((m & mask) == (n & mask)) {
                result |= (m & mask);
            } else {
                break;
            }
            mask >>= 1;
        }
        return result;
    }
}
