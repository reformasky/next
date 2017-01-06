package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 1/1/17.
 */
public class MinSubArray_209 {
    public int minSubArrayLen_2ptr(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (s == 0) {
            return 1;
        }
        int b = 0, e = 0, sum = 0, res = Integer.MAX_VALUE;
        while(e < nums.length) {
            sum += nums[e++];
            while(sum >= s) {
                res = Math.min(res, e - b);
                sum -= nums[b++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] sums = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        if (sums[nums.length] < s) {
            return 0;
        }
        int result = nums.length;
        for(int i = nums.length; sums[i] >= s; i--) {
            int j = Arrays.binarySearch(sums, 0, i, sums[i] - s);
            int insertPoint = j >= 0 ? j : (-2 - j);
            result = Math.min(result, i - insertPoint);
        }
        return result;
    }
}
