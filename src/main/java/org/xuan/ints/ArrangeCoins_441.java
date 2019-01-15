package org.xuan.ints;

/**
 * Created by xzhou2 on 2/23/17.
 */
public class ArrangeCoins_441 {
    public int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        long max = n, low = 1, high = max;
        while(low <= high) {
            long mid = (high + low) / 2, prod;
            if (mid % 2 == 0) {
                prod = mid / 2 * (mid + 1);
            } else {
                prod = (mid + 1) / 2 * mid;
            }
            if (prod == max) {
                return (int)mid;
            } else if (prod > max) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)high;
    }
}
