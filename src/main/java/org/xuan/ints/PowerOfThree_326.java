package org.xuan.ints;

/**
 * Created by xzhou2 on 1/18/17.
 */
public class PowerOfThree_326 {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
