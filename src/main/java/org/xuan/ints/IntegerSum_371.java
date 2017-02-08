package org.xuan.ints;

/**
 * Created by xzhou2 on 1/24/17.
 */
public class IntegerSum_371 {
    public int getSum(int a, int b) {
        int carryOver = 0, result = 0;
        for(int i = 0; i < 32; i++) {
            int first = a & 1, second = b & 1;
            result |= (first ^ second ^carryOver) << i;
            carryOver = ((first & second) | (first & carryOver) | (second & carryOver));
            a >>= 1;
            b >>= 1;
        }
        return result;
    }
}
