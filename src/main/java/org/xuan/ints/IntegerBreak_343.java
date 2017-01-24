package org.xuan.ints;

/**
 * Created by xzhou2 on 1/20/17.
 */
public class IntegerBreak_343 {
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 4) {
            return 4;
        } else {
            int result = 1;
            while(n > 4) {
                result *= 3;
                n -= 3;
            }
            result *= n;
            return result;
        }
    }
}
