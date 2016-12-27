package org.xuan.array;

/**
 * Created by xzhou2 on 12/21/16.
 */
public class MaxProduct_152 {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE, maxPos = 1, maxNeg = 0;
        if(nums.length == 0) {
            return 0;
        }
        for(int n : nums) {
            int tmpP = maxPos, tmpN = maxNeg;
            if (n == 0) {
                maxPos = 1;
                maxNeg = 0;
                result = Math.max(result, 0);
            } else if (n > 0) {
                maxPos = tmpP > 0 ? n * tmpP : n;
                maxNeg = tmpN * n;
                result = Math.max(maxPos, result);
            } else {
                maxNeg = tmpP  > 0 ? tmpP * n : n;
                maxPos = tmpN < 0 ? n * tmpN : 0;
                if (maxNeg != 0) {
                    result = Math.max(result, maxNeg);
                }
                if (maxPos != 0) {
                    result = Math.max(result, maxPos);
                }
            }
        }
        return result;
    }
}
