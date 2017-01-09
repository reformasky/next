package org.xuan.array;

/**
 * Created by xzhou2 on 1/8/17.
 */
public class SingleNumberIII_260 {
    public int[] singleNumber(int[] nums) {
        int mask1 = 0, mask2 = 0;
        for(int n : nums) {
            mask1 ^= n;
        }
        mask2 = (mask1) & (~(mask1 - 1));
        int result1 = 0, result2 = 0;
        for(int n : nums) {
            if ((n & mask2) != 0) {
                result1 ^= n;
            } else {
                result2 ^= n;
            }
        }
        return new int[]{result1, result2};
    }
}
