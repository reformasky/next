package org.xuan.ints;

/**
 * Created by xzhou2 on 1/24/17.
 */
public class CountNumberWithUniqueDigits_357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10) {
            return countNumbersWithUniqueDigits(10);
        }
        if (n <= 0) {
            return 1;
        }
        int curr = 9, res = curr, counter = 1;
        while(counter++ < n) {
            res *= curr--;
        }
        return res + countNumbersWithUniqueDigits(n - 1);
    }
}
