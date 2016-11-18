package org.xuan.ints;

/**
 * Created by xzhou2 on 11/15/16.
 */
public class IsPalindrome_8 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while(x / 10 >= div ) {
            div *= 10;
        }
        while (div > 1) {
            if (x / div != x % 10) {
                return false;
            }
            x %= div;
            x /= 10;
            div /= 100;
        }
        return true;
    }
}
