package org.xuan.ints;

/**
 * Created by xzhou2 on 1/7/17.
 */
public class CountDigitOne_233 {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        long base = 1;
        long result = 0;
        while(base <= n) {
            long q = n / (10 *base), r = base == 1 ? 0 : (n % base),
                    c = n / base % 10;
            //	System.out.println(q + " " + r + " "+ c + " " +result);
            if (c > 1) {
                result += (q + 1) * base;
            } else if (c == 1) {
                result += q * base + r + 1;
            } else {
                result += q * base;
            }
            base *= 10;
        }
        return  (int)result;

    }
}
