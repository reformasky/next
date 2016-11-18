package org.xuan.ints;

/**
 * Created by xzhou2 on 11/15/16.
 */
public class ReverseInt_7 {
    public int reverse(int x) {
        boolean isNeg = (x < 0);
        long input = x, output = 0;
        if (isNeg) {
            input = -x;
        }
        while(input > 0) {
            output = 10 * output + (input % 10 );
            input /= 10;
        }
        if (isNeg) {
            output = -output;
            if (output < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return output <= Integer.MAX_VALUE? (int) output : 0;
    }
}
