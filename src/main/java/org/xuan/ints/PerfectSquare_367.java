package org.xuan.ints;

/**
 * Created by xzhou2 on 1/24/17.
 */
public class PerfectSquare_367 {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }
        long low = 1, high = num;
        while(low <= high) {
            long root = (low + high) / 2;
            long sq = root * root;
            if (sq == num) {
                return true;
            } else if (sq > num) {
                high = root - 1;
            } else{
                low = root + 1;
            }
        }
        return false;
    }
}
