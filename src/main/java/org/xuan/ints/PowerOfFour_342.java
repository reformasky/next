package org.xuan.ints;

/**
 * Created by xzhou2 on 1/20/17.
 */
public class PowerOfFour_342 {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while(num > 1) {
            if (num % 4 != 0) {
                return false;
            }
            num >>= 2;
        }
        return num == 1;
    }
}
