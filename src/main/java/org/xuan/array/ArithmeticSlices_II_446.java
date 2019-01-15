package org.xuan.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 2/25/17.
 */
public class ArithmeticSlices_II_446 {
    public int numberOfArithmeticSlices(int[] A) {
        int result = 0, len = A.length;
        @SuppressWarnings("unchecked")
        Map<Long, Integer>[] maps = (Map<Long, Integer>[]) new Map[len];
        for(int i = 0; i < len; i++) {
            maps[i] = new HashMap<>();
        }
        //diff : [length : count]
        Map<Long, Integer> pre, curr;
        for(int i = 1; i < len; i++) {
            curr = maps[i];
            for(int j = i - 1; j >= 0; j--) {
                long diff = (long)A[i] - A[j];
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue;
                }
                pre = maps[j];
                Integer preCount = pre.getOrDefault(diff, 0),
                        currCount = curr.getOrDefault(diff, 0);
                result += preCount;
                currCount += preCount  + 1;
                curr.put(diff, currCount);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2,2,4,4,6};
        ArithmeticSlices_II_446 a = new ArithmeticSlices_II_446();
        a.numberOfArithmeticSlices(A);
    }
}
