package org.xuan.ints;

/**
 * Created by xzhou2 on 11/21/16.
 */
public class DividedTwoIntegers_29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException();
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        int res = 0;
        boolean negative = (dividend ^ divisor) < 0;
        divisor = divisor > 0 ? divisor : - divisor;
        if (dividend == Integer.MIN_VALUE) {
            res = 1;
            dividend += divisor;
        }
        dividend = dividend > 0 ? dividend : -dividend;
        int shift = 0;
        while((divisor << (shift + 1)) > 0 && (divisor << (1 + shift)) <= dividend ) {
            shift++;
        }
        while(shift >= 0) {
            if (dividend >= (divisor << shift)) {
                res += (1 << shift);
                dividend -= (divisor << shift);
            }
            shift--;
        }
        return negative ? -res : res;
    }
}
