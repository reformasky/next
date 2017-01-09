package org.xuan.ints;

/**
 * Created by xzhou2 on 1/6/17.
 */
public class AddDigits_258 {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        int mod = num % 9;
        return mod == 0 ? 9 : mod;
    }
}
