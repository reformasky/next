package org.xuan.array;

/**
 * Created by xzhou2 on 12/19/16.
 */
public class SingleNumberI_136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int n : nums) {
            result ^= n;
        }
        return result;
    }
}
