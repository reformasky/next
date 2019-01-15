package org.xuan.ints;

/**
 * Created by xzhou2 on 3/4/17.
 */
public class NumberComplement_476 {
    public int findComplement(int num) {
        int mask = - 1;
        for(int i = 31; i >= 0; i--) {
            if ((num & (1 << i)) != 0) {
                break;
            }
            mask ^= 1 << i;
        }
        return mask & (~num);
    }
}
