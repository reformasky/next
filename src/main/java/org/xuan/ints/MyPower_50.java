package org.xuan.ints;

/**
 * Created by xzhou2 on 12/2/16.
 */
public class MyPower_50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if (n < 0) {
            double tmp = myPow(x, -(n + 1));
            return 1 / x / tmp;
        } else {
            double tmp = myPow(x, n / 2);
            if (n % 2 == 0) {
                return tmp * tmp;
            } else {
                return x * tmp * tmp;
            }
        }
    }
}
