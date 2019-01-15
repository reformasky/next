package org.xuan.ints;

/**
 * Created by xzhou2 on 3/29/17.
 */
public class PerfectNumber_507 {
    public boolean checkPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }
        int left = 2, sum = 1, right;
        while((right = num / left) >= left) {
            if (num % left == 0) {
                sum += left;
                if (right != left) {
                    sum += right;
                }
            }
            left++;
        }
        return sum == num;
    }
}
