package org.xuan.ints;

/**
 * Created by xzhou2 on 12/30/16.
 */
public class ReverseBits_190 {
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            result |= ((n >> i) & 1 ) << (31 - i);
        }
        return result;
    }
}
