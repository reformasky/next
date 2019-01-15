package org.xuan.ints;

/**
 * Created by xzhou2 on 3/2/17.
 */
public class HammingDistance_461 {
    public int hammingDistance(int x, int y) {
        int result = 0;
        int xor = x ^ y;
        for(int i = 0; i < 32; i++) {
            result += (xor & 1);
            xor >>= 1;
        }
        return result;
    }
}
