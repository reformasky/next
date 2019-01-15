package org.xuan.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 2/27/17.
 */
public class FourSumII_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        for(int a : A) {
            for(int b : B) {
                int sum = a + b;
                sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
            }
        }
        int result = 0;
        for(int c : C) {
            for(int d : D) {
                int sum = -(c + d);
                result += sumToCount.getOrDefault(sum, 0);
            }
        }
        return result;
    }
}
