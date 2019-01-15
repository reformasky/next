package org.xuan.array;

/**
 * Created by xzhou2 on 2/20/17.
 */
public class ArithmeticSlices_413 {
    public int numberOfArithmeticSlices(int[] A) {
        int result = 0, pre = 0;
        if (A.length < 3) {
            return result;
        }
        int diff = A[2] - A[1], preDiff = A[1] - A[0];
        for(int i = 2; i < A.length; i++) {
            diff = A[i] - A[i - 1];
            if (diff == preDiff) {
                pre = pre + 1;
                result += pre;
            } else {
                pre = 0;
            }
            preDiff = diff;
        }
        return result;
    }
}
