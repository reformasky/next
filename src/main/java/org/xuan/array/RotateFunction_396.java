package org.xuan.array;

/**
 * Created by xzhou2 on 2/9/17.
 */
public class RotateFunction_396 {
    public int maxRotateFunction(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        long result, curr = 0, sum = 0;
        for(int i = 0; i < A.length; i++) {
            curr += i * A[i];
            sum += A[i];
        }
        result = curr;
        int index = A.length - 1;
        while(index > 0) {
            curr += sum - A.length * A[index--];
            result = Math.max(curr, result);
        }
        return (int)result;
    }
}
