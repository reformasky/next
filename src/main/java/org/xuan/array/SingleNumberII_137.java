package org.xuan.array;

/**
 * Created by xzhou2 on 12/19/16.
 */
public class SingleNumberII_137 {
    int len = 32;
    public int singleNumber(int[] nums) {
        int[] cache = new int[len];
        int result = 0;
        for(int n : nums) {
            for(int i = 0; i < len; i++) {
                cache[i] += ((n >> i) & 1);
            }
        }
        for(int i = 0; i < len; i++) {
            result += ((cache[i] % 3) << i);
        }
        return result;
    }
}
