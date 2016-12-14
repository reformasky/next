package org.xuan.ints;

/**
 * Created by xzhou2 on 12/8/16.
 */
public class Sqrt_69 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        long low = 1, high = x, mid ;

        while(low <= high) {
            mid = low + (high - low) / 2;
            long eval = mid * mid;
            if (eval == x) {
                return (int)mid;
            } else if (eval > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)high;
    }
}
