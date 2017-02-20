package org.xuan.array;

/**
 * Created by xzhou2 on 2/9/17.
 */
public class IntegerReplacement_397 {
    public int integerReplacement(int n) {
        if(n < 4) {
            return n - 1;
        }
        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        }
        if ((n / 2 + 1) % 2 == 0) {
            return 2 + integerReplacement(n / 2 + 1);
        } else {
            return 2 + integerReplacement(n/2);
        }
    }
}
