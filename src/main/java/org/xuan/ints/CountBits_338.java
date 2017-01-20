package org.xuan.ints;

/**
 * Created by xzhou2 on 1/17/17.
 */
public class CountBits_338 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int index = 1;
        while(index < result.length) {
            int size = index;
            for(int i = 0; i < size && index < result.length; i++, index++) {
                result[index] = result[i] + 1;
            }
        }
        return result;
    }
}
